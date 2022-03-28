package pl.robert.suncode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SuncodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuncodeApplication.class, args);
    }
}
