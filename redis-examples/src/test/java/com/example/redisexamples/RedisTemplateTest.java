package com.example.redisexamples;

public class RedisTemplateTest {
}
/*

@SpringBootTest
@Slf4j
public class RedisTemplateTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() {
        User user = User.builder().id(1L).name("BO").build();
        redisTemplate.opsForValue().set("1",user);
    }

    @Test
    public void test2() {
        //User user = redisTemplate.opsForValue().g
    }
}

 */