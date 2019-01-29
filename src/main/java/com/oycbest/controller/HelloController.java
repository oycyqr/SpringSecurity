package com.oycbest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: oyc
 * @Date: 2019/1/29 10:49
 * @Description: Hello 测试控制类
 */
@RestController
public class HelloController {
    @GetMapping("hello")
    public String hello(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "hello";
    }
}