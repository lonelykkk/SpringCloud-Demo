package com.kkk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date ${DATE} ${TIME}
 * @Version V1.0
 */
@SpringBootApplication
@MapperScan("com.kkk.mapper")
public class UserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}