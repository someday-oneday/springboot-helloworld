package com.example.springexamples.example03;

import com.example.springexamples.example02.aop.AOPService;
import com.example.springexamples.example03.jointpoint.AOPservice03;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class AOPServiceTset {
    @Autowired
    private AOPservice03 aoPservice03;
    @Test
    public void test_hello(){
        log.debug(aoPservice03.hello("BO"));
    }
}
