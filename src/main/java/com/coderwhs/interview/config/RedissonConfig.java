package com.coderwhs.interview.config;

import lombok.Data;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author whs
 * @Date 2024/10/4 17:26
 * @description:
 */
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class RedissonConfig {
  private String host;
  private Integer port;
  private Integer database;
  private String password;

  @Bean
  public RedissonClient redissonClient(){
    Config config = new Config();
    config.useSingleServer()
      .setAddress("redis://"+host+":"+port)
      .setDatabase(database)
      .setPassword(password);
    return Redisson.create(config);
  }
}
