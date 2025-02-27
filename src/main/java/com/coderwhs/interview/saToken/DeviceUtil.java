package com.coderwhs.interview.saToken;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.Header;
import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentUtil;
import com.coderwhs.interview.common.ErrorCode;
import com.coderwhs.interview.exception.ThrowUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author whs
 * @Date 2024/10/7 11:09
 * @description: 获取请求设备工具类
 */
public class DeviceUtil {

  /**
   * 获取当前请求的设备来源
   * @param request
   * @return
   */
  public static String getRequestDevice(HttpServletRequest request){

    String userAgentStr = request.getHeader(Header.USER_AGENT.toString());

    //使用hutool包的工具类解析
    UserAgent userAgent = UserAgentUtil.parse(userAgentStr);
    ThrowUtils.throwIf(userAgent == null, ErrorCode.OPERATION_ERROR,"非法请求");

    // 默认值是 PC
    String device = "pc";
    if (isMiniProgram(userAgentStr)) {
      // 是否为小程序
      device = "miniProgram";
    } else if (isPad(userAgentStr)) {
      // 是否为 Pad
      device = "pad";
    } else if (userAgent.isMobile()) {
      // 是否为手机
      device = "mobile";
    }
    return device;

  }

  /**
   * 判断是否是小程序
   * 一般通过 User-Agent 字符串中的 "MicroMessenger" 来判断是否是微信小程序
   **/
  private static boolean isMiniProgram(String userAgentStr) {
    // 判断 User-Agent 是否包含 "MicroMessenger" 表示是微信环境
    return StrUtil.containsIgnoreCase(userAgentStr, "MicroMessenger")
      && StrUtil.containsIgnoreCase(userAgentStr, "MiniProgram");
  }

  /**
   * 判断是否为平板设备
   * 支持 iOS（如 iPad）和 Android 平板的检测
   **/
  private static boolean isPad(String userAgentStr) {
    // 检查 iPad 的 User-Agent 标志
    boolean isIpad = StrUtil.containsIgnoreCase(userAgentStr, "iPad");

    // 检查 Android 平板（包含 "Android" 且不包含 "Mobile"）
    boolean isAndroidTablet = StrUtil.containsIgnoreCase(userAgentStr, "Android")
      && !StrUtil.containsIgnoreCase(userAgentStr, "Mobile");

    // 如果是 iPad 或 Android 平板，则返回 true
    return isIpad || isAndroidTablet;
  }
}
