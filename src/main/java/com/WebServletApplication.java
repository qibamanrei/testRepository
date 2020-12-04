package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class WebServletApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebServletApplication.class);     //(WebServletApplication.class， args)
    }
}
