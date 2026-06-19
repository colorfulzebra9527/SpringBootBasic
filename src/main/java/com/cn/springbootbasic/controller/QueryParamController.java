package com.cn.springbootbasic.controller;

import com.cn.springbootbasic.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 演示：无注解接参
 * 方法形参名与请求参数名一致时，Spring Boot 自动绑定，无需任何注解。
 * 测试地址：http://localhost:8080/qp/demo?id=1&name=zxx
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
@RequestMapping("/qp")
public class QueryParamController {

    // 注意：URL 中的参数名 id、name 必须与方法形参名 String id、String name 完全一致，否则无法绑定。
    // 测试地址：http://localhost:8080/qp/demo?id=1&name=zxx
    @RequestMapping("/demo")
    public String demo(String id, String name) {
        return "无注解接参 → id=" + id + ", name=" + name;
    }

}
