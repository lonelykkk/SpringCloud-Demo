package com.kkk.controller;

import com.kkk.domain.dto.UserDto;
import com.kkk.domain.vo.UserLoginVo;
import com.kkk.result.Result;
import com.kkk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/12/22 18:46
 * @Version V1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public Result register(@RequestBody UserDto userDto) {
        userService.addUser(userDto);
        return Result.success("注册成功");
    }

    @PostMapping("/login")
    public Result<UserLoginVo> login(@RequestBody UserDto userDto) {
        UserLoginVo userLoginVo = userService.login(userDto);
        return Result.success(userLoginVo);
    }
}
