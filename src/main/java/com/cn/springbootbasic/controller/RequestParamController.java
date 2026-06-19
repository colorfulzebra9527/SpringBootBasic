package com.cn.springbootbasic.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 演示：@RequestParam 注解接参
 * 该注解用于将 HTTP 请求参数绑定到方法形参，支持参数别名、默认值、是否必填等配置。
 * 用法包括：基本绑定、参数别名、默认值、非必填。
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
@RequestMapping("/rp")
public class RequestParamController {

    /**
     * 基本用法：通过 @RequestParam 显式绑定请求参数。
     * 与无注解接参不同，@RequestParam 允许方法形参名与 URL 参数名不一致。
     * 例如：URL 中是 ?id=1，形参可以写成 @RequestParam("id") String userId。
     * 测试地址：http://localhost:8080/rp/demo?id=1&name=zxx
     */
    @RequestMapping("/demo")
    public String demo(@RequestParam("id") String userId,
                       @RequestParam("name") String userName) {
        return "@RequestParam 基本用法 → id=" + userId + ", name=" + userName;
    }

    /**
     * 默认值与非必填：
     *   - defaultValue = "18"：URL 中不传 age 时，自动使用默认值 18。
     *   - required = false：nickname 不是必须传的，不传时值为 null。
     * 测试地址（不传参数，使用默认值）：http://localhost:8080/rp/dv
     * 测试地址（传入参数）：http://localhost:8080/rp/dv?age=25&nickname=zxx
     */
    @RequestMapping("/dv")
    public String defaultValue(@RequestParam(value = "age", defaultValue = "18") int age,
                               @RequestParam(value = "nickname", required = false) String nickname) {
        return "@RequestParam 默认值与非必填 → age=" + age + ", nickname=" + nickname;
    }
}
