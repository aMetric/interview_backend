package com.coderwhs.interview.constant;

/**
 * @Author whs
 * @Date 2024/10/4 20:10
 * @description: redis相关常量
 */
public interface RedisConstant {

  /**
   * 记录用户签到记录的redis key常量
   */
  String USER_SIGN_IN_REDIS_KEY_PREFIX = "user:signins";

  static String getUserSignInRedisKey(int year, long userId){
    return String.format("%s:%s:%S",USER_SIGN_IN_REDIS_KEY_PREFIX,year,userId);
  }
}
