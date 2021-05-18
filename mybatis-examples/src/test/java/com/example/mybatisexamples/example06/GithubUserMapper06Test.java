package com.example.mybatisexamples.example06;

import com.example.mybatisexamples.entity.GithubUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
@SpringBootTest
@Slf4j
public class GithubUserMapper06Test {
    @Autowired
    private GithubUserMapper06 githubUserMapper06;
    @Test
    public void querywrapper_test(){
        QueryOptional optionals = QueryOptional.builder()
                .stars(10)
                .repos(10)
                .followers(100)
                .beforeCreateTime(LocalDateTime.of(2018, 1, 1, 0 ,0))
                .build();
        for (GithubUser g : githubUserMapper06.listByOptionals(optionals)){
            log.debug("{}", g.getName());
        }
    }
    @Test
    public void querywrapperxml_test(){
        QueryOptional optionals = QueryOptional.builder()
                .repos(10)
                .beforeCreateTime(LocalDateTime.of(2018, 1, 1, 0, 0))
                .build();
        for (GithubUser g : githubUserMapper06.listByOptionals2(optionals)){
            log.debug("{}", g.getName());
        }
    }
}
