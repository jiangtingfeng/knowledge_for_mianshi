package com.util;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.extern.slf4j.Slf4j;
import javax.servlet.http.HttpServletRequest;

/**
 * Ip工具类
 *
 * @author liujianqiang
 * @date 2019年1月4日
 */
public class IpUtils {

    /**
     * 获取客户端ip
     *
     * @param request
     * @return
     * @author liujianqiang
     * @data 2019年1月4日
     */
    public static String getClientIpAddr(HttpServletRequest request) {
        final String unknown = "unknown";
        String xip = request.getHeader("X-Real-IP");
        String xFor = request.getHeader("X-Forwarded-For");
        if (StringUtils.isNotEmpty(xFor) && !unknown.equalsIgnoreCase(xFor)) {
            //log.info("获取IP地址 from {}", "X-Forwarded-For");
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = xFor.indexOf(",");
            if (index != -1) {
                return xFor.substring(0, index);
            } else {
                return xFor;
            }
        }
        xFor = xip;
        if (StringUtils.isNotEmpty(xFor) && !unknown.equalsIgnoreCase(xFor)) {
            //log.info("获取IP地址 from {}", "X-Real-IP");
            return xFor;
        }
        if (StringUtils.isBlank(xFor) || unknown.equalsIgnoreCase(xFor)) {
            //log.info("获取IP地址 from {}", "Proxy-Client-IP");
            xFor = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(xFor) || unknown.equalsIgnoreCase(xFor)) {
            //log.info("获取IP地址 from {}", "WL-Proxy-Client-IP");
            xFor = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(xFor) || unknown.equalsIgnoreCase(xFor)) {
            //log.info("获取IP地址 from {}", "HTTP_CLIENT_IP");
            xFor = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isBlank(xFor) || unknown.equalsIgnoreCase(xFor)) {
            //log.info("获取IP地址 from {}", "HTTP_X_FORWARDED_FOR");
            xFor = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isBlank(xFor) || unknown.equalsIgnoreCase(xFor)) {
            //log.info("获取IP地址 from {}", "request.getRemoteAddr()");
            xFor = request.getRemoteAddr();
        }
        return xFor;
    }


}
