package com.coderwhs.interview.manager;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RScript;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.IntegerCodec;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * @Author whs
 * @Date 2024/10/7 13:19
 * @description: 通用计数器：可实现频率统计、限流、封禁
 */
@Slf4j
@Service
public class CounterManager {

  @Resource
  private RedissonClient redissonClient;

  /**
   * 增加并返回计数，默认统计一分钟内的计数结果
   *
   * @param key 缓存键
   * @return
   */
  public long incrAndGetCounter(String key) {
    return incrAndGetCounter(key, 1, TimeUnit.MINUTES);
  }

  /**
   * 增加并返回计数
   *
   * @param key          缓存键
   * @param timeInterval 时间间隔
   * @param timeUnit     时间间隔单位
   * @return
   */
  public long incrAndGetCounter(String key, int timeInterval, TimeUnit timeUnit) {
    int expirationTimeInSeconds;
    switch (timeUnit) {
      case SECONDS:
        expirationTimeInSeconds = timeInterval;
        break;
      case MINUTES:
        expirationTimeInSeconds = timeInterval * 60;
        break;
      case HOURS:
        expirationTimeInSeconds = timeInterval * 60 * 60;
        break;
      default:
        throw new IllegalArgumentException("Unsupported TimeUnit. Use SECONDS, MINUTES, or HOURS.");
    }

    return incrAndGetCounter(key, timeInterval, timeUnit, expirationTimeInSeconds);
  }

  /**
   * 增加并返回计数
   * @param key redis的key
   * @param timeInterval 时间间隔
   * @param timeUnit 间隔单位
   * @param expireSeconds 计数器缓存过期时间
   * @return
   */
  public long incrAndGetCounter(String key, int timeInterval, TimeUnit timeUnit, long expireSeconds){

    if (StrUtil.isBlank(key)){
      return 0;
    }

    //根据时间粒度生成redis key
    long timeFactor;
    switch (timeUnit){
      case SECONDS:
        timeFactor = Instant.now().getEpochSecond() / timeInterval;
        break;
      case MINUTES:
        timeFactor = Instant.now().getEpochSecond() / 60 / timeInterval;
        break;
      case HOURS:
        timeFactor = Instant.now().getEpochSecond() / 3600 / timeInterval;
        break;
      default:
        throw new IllegalArgumentException("Unsupported TimeUnit. Use SECONDS, MINUTES, or HOURS.");
    }

    String redisKey = key + ":" + timeFactor;

    //lua脚本
    // 检查 Redis 中是否存在该键 (KEYS[1])。
    // 如果存在，调用 incr 命令增加计数并返回当前值。
    // 如果不存在，设置该键的值为 1，并设置过期时间 (expire) 为 expireSeconds，然后返回 1。
    String luaScript =
        "if redis.call('exists', KEYS[1]) == 1 then " +
        "  return redis.call('incr', KEYS[1]); " +
        "else " +
        "  redis.call('set', KEYS[1], 1); " +
        "  redis.call('expire', KEYS[1], ARGV[1]); " +
        "  return 1; " +
        "end";

    //执行Lua脚本
    RScript rScript = redissonClient.getScript(IntegerCodec.INSTANCE);
    Object countObj = rScript.eval(
      RScript.Mode.READ_WRITE,              //脚本的执行模式
      luaScript,
      RScript.ReturnType.INTEGER,           //返回类型
      Collections.singletonList(redisKey),
      expireSeconds                         //过期时间
    );
    return (long)countObj;
  }
}
