package ren.shuaipeng.shardingsphere.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ren.shuaipeng.shardingsphere.demo.model.UserEntity;
import ren.shuaipeng.shardingsphere.demo.model.UserLoginReq;
import ren.shuaipeng.shardingsphere.demo.model.UserRegisterReq;
import ren.shuaipeng.shardingsphere.demo.service.UserService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public UserEntity login(@RequestBody UserLoginReq req) {
        return userService.login(req);
    }

    @PostMapping("/register")
    public String register(@RequestBody UserRegisterReq req) {
        userService.register(req);
        return "REGISTER OK";
    }
}
