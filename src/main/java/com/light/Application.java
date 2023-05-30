package com.light;

import com.light.common.exception.BusinessException;
import com.light.common.exception.BusinessExceptionErrorEnum;
import jakarta.servlet.http.HttpServletRequest;
import org.beetl.ext.spring6.EnableBeetl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@MapperScan("com.light.business.*.mapper")
@EnableBeetl
@RestController
@SpringBootApplication
public class Application {
    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/404")
    public String error404() {
        return "404";
    }

    @RequestMapping("/500")
    public void handlerFilterError(HttpServletRequest request) {
        throw new BusinessException(BusinessExceptionErrorEnum.SYSTEM_ERROR);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
