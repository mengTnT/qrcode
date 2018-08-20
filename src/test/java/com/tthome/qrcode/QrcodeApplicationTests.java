package com.tthome.qrcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static jdk.nashorn.internal.objects.NativeString.substring;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QrcodeApplicationTests {

    @Test
    public void contextLoads() {


    }

    public static void main(String[] args) {
        String a="aaaaaaaaaaaa";
        String substring = a.substring(0, 180);
        System.out.println(substring);
    }

}
