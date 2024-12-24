package com.kkk.controller;

import com.kkk.annotation.GlobalInterceptor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/12/22 18:39
 * @Version V1.0
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GlobalInterceptor
    @GetMapping("/test")
    public String test() {
        return "ok";
    }
}
