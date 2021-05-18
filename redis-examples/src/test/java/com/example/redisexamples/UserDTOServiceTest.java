package com.example.redisexamples;

public class UserDTOServiceTest {
}
/*

@SpringBootTest
@Slf4j
public class UserDTOServiceTest {
    @Autowired
    private UserDTOService userDTOService;

    @Test
    public void test() throws InterruptedException {
        userDTOService.getUserDTO(1);
        new Thread(() -> {
            int count = 0;
            boolean run = true;
            while (run) {
                try {
                    Thread.sleep(new Random().nextInt(150));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int result = userDTOService.updateUserDTO(1);
                if (result == -1) {
                    run = false;
                } else {
                    count++;
                }
            }
            log.debug("A: {}", count);
        }).start();

        new Thread(() -> {
            int count = 0;
            boolean run = true;
            while (run) {
                try {
                    Thread.sleep(new Random().nextInt(150));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int result = userDTOService.updateUserDTO(1);
                if (result == -1) {
                    run = false;
                } else {
                    count++;
                }
            }
            log.debug("B: {}", count);
        }).start();
        Thread.sleep(5000);
        log.debug("end");
    }
}

 */