package com.tthome.qrcode;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tthome.qrcode.dao")
public class QrcodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(QrcodeApplication.class, args);
    }
}
