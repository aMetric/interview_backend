package com.coderwhs.interview.config;

import com.jd.platform.hotkey.client.ClientStarter;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author whs
 * @Date 2024/10/6 13:05
 * @description: jd hotkey 热key发现配置
 */
@Configuration
@ConfigurationProperties(prefix = "hotkey")
@Data
public class HotKeyConfig {

  /**
   * Etcd 服务器完整地址
   */
  @Value("${hotkey.etcd-server}")
  private String etcdServer;

  /**
   * 应用名称
   */
  private String appName = "app";

  /**
   * 本地缓存最大数量
   */
  private int caffeineSize = 10000;

  /**
   * 批量推送 key 的间隔时间
   */
  private long pushPeriod = 1000L;

  /**
   * 初始化 hotkey
   */
  @Bean
  public void initHotkey() {
    ClientStarter.Builder builder = new ClientStarter.Builder();
    ClientStarter starter = builder.setAppName(appName)
      .setCaffeineSize(caffeineSize)
      .setPushPeriod(pushPeriod)
      .setEtcdServer(etcdServer)
      .build();
    starter.startPipeline();
  }
}
