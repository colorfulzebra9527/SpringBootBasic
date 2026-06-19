package com.cn.springbootbasic.controller;

import com.cn.springbootbasic.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 演示：@RequestBody 接收 JSON 请求体
 * 前端通过 fetch 发送 JSON，后端用 @RequestBody 反序列化为 Java 对象。
 * 配套前端页面：/body.html
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
@RequestMapping("/rb")
public class RequestBodyController {

    // 注意：前端发送的请求必须设置 Content-Type: application/json，
    // 且 JSON 中的字段名（id、name、gender、age）必须与 User 类的属性名一致。
    // 配套前端页面：/body.html（通过 fetch 发送 JSON）

    @RequestMapping("/demo")
    public String demo(@RequestBody User user) {
        return "@RequestBody 接收 JSON → " + user;
    }


}
