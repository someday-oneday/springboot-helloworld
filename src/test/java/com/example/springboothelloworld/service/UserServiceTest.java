package com.example.springboothelloworld.service;

import com.example.springboothelloworld.util.MyUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserServiceTest {
    @Autowired
    private UserService userService;
    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Test
    public void test_logging(){
        String str = "dhd";
        log.debug("hjhkh()", str);
    }

    @Test
    @DisplayName("输入1+1，预期2")
    public void test_add(){
        Assertions.assertEquals(3, userService.add(1, 2));
    }

    @Test
    public void test_addString(){
        Assertions.assertThrows(Exception.class, () -> {
            userService.addString("BO");
        });
    }
}
