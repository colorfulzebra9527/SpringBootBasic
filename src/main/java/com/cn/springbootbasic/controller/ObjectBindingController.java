package com.cn.springbootbasic.controller;

import com.cn.springbootbasic.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 演示：对象自动绑定
 * 请求参数名与 POJO 属性名一致时，Spring Boot 自动将参数注入对象。
 * 测试地址：http://localhost:8080/ob/demo?id=1&name=zxx&gender=male&age=19
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
@RequestMapping("/ob")
public class ObjectBindingController {

    // 注意：URL 中的参数名 id、name、gender、age 必须与 User 类中的属性名完全一致，Spring Boot 才会自动填充。
    // 测试地址：http://localhost:8080/ob/demo?id=1&name=zxx&gender=male&age=19
    @RequestMapping("/demo")
    public String demo(User user) {
        return "对象自动绑定 → " + user;
    }

}
