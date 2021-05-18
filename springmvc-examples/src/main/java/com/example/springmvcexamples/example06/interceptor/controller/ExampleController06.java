package com.example.springmvcexamples.example06.interceptor.controller;

import com.example.springmvcexamples.example05.textencryptor.EncryptComponent05;
import com.example.springmvcexamples.example06.interceptor.entity.User06;
import com.example.springmvcexamples.example06.interceptor.service.UserService06;
import com.example.springmvcexamples.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/example06/")
public class ExampleController06 {
    @Autowired
    private UserService06 userService06;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private EncryptComponent05 encryptComponent05;
    @PostMapping("login")
    public ResultVO login(@RequestBody User06 user06, HttpServletResponse response){
        User06 u = userService06.getUser(user06.getUserName());
        if (u == null || !encoder.matches(user06.getPassword(), u.getPassword())){
            return ResultVO.error(401, "用户名密码错误");
        }
        // 登录成功，模拟获取用户id角色等信息，加密
        String result = encryptComponent05.encrypt(Map.of("uid", u.getId(), "role", u.getRole()));
        log.debug(result);
        // 以指定键值对，置于响应header
        response.addHeader("token", result);
        return ResultVO.success(Map.of());
    }
    @GetMapping("admin/welcome")
    public ResultVO getWelcome(@RequestAttribute("role") String role){
        log.debug(role);
        return ResultVO.success(Map.of("msg", "欢迎回来"));
    }
}