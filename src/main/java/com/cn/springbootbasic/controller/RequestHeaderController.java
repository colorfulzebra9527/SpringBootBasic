package com.cn.springbootbasic.controller;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 演示：@RequestHeader 获取请求头
 * 通过 @RequestHeader 注解获取 HTTP 请求头中的指定字段值。
 * 测试地址：http://localhost:8080/rh/demo
 *
 * 学习顺序：
 * 1. QueryParamController — 无注解接参
 * 2. RequestParamController — @RequestParam
 * 3. ObjectBindingController — 对象自动绑定
 * 4. RequestHeaderController — @RequestHeader
 * 5. CookieValueController — @CookieValue
 * 6. RequestBodyController — @RequestBody JSON
 */
@RestController
@RequestMapping("/rh")
public class RequestHeaderController {

    // @RequestHeader("xxx") 中的值必须是真实的 HTTP 请求头名称。
    // User-Agent 和 Host 是浏览器每次请求都会自动携带的请求头字段。
    // 测试地址：http://localhost:8080/rh/demo
    @RequestMapping("/demo")
    public String demo(@RequestHeader("User-Agent") String userAgent,
                       @RequestHeader("Host") String host) {
        return "@RequestHeader → Host=" + host + ", User-Agent=" + userAgent;
    }
}
