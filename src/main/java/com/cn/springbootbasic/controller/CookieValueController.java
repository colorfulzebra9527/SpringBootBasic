package com.cn.springbootbasic.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 演示：@CookieValue 获取 Cookie
 * 通过 @CookieValue 注解直接获取请求中指定名称的 Cookie 值。
 * 测试地址：http://localhost:8080/cv/demo
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
@RequestMapping("/cv")
public class CookieValueController {

    /**
     * 先写入 Cookie，方便后续演示读取。
     * 访问此方法后浏览器会保存 Cookie，之后访问 /cv/demo 即可读取。
     * 测试地址：http://localhost:8080/cv/set
     */
    @RequestMapping("/set")
    public String setCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("myCookie", "hello-cookie");
        cookie.setPath("/");
        response.addCookie(cookie);
        return "Cookie 已写入，请访问 /cv/demo 查看";
    }

    // @CookieValue("myCookie") 中的值必须与 Cookie 的名称一致。
    // defaultValue 表示当请求中没有该 Cookie 时，使用默认值而不是报错。
    // 注意：必须先访问 /cv/set 写入 Cookie，再访问 /cv/demo 才能读取到。
    // 测试地址：http://localhost:8080/cv/demo
    @RequestMapping("/demo")
    public String demo(@CookieValue(value = "myCookie", defaultValue = "无Cookie") String myCookie) {
        return "@CookieValue → myCookie=" + myCookie;
    }
}
