package com.coderwhs.interview.blackFilter;

import cn.hutool.bloomfilter.BitMapBloomFilter;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import org.yaml.snakeyaml.Yaml;

import java.net.StandardSocketOptions;
import java.util.List;
import java.util.Map;

/**
 * @Author whs
 * @Date 2024/10/6 23:24
 * @description: 黑名单过滤工具类
 */
@Slf4j
public class BlackIpUtils {

  private static BitMapBloomFilter bloomFilter;

  //判断ip是否在黑名单中
  public static boolean isBlackIp(String ip){
    return bloomFilter.contains(ip);
  }

  /**
   * 重建ip黑名单
   * @param configInfo
   */
  public static void rebuildBlackIp(String configInfo){
    if (StrUtil.isBlank(configInfo)){
      configInfo = "{}";
    }
    //解析yaml
    Yaml yaml = new Yaml();
    Map map = yaml.loadAs(configInfo, Map.class);
    List<String> blackIpList = (List<String>)map.get("blackIpList");
    //加锁，防止并发
    synchronized(BlackIpUtils.class){
      if (CollUtil.isNotEmpty(blackIpList)){
        BitMapBloomFilter bitMapBloomFilter = new BitMapBloomFilter(958506);
        for (String blackIp : blackIpList){
          bitMapBloomFilter.add(blackIp);
        }
        bloomFilter = bitMapBloomFilter;
      }else{
        bloomFilter = new BitMapBloomFilter(100);
      }
    }
  }
}
