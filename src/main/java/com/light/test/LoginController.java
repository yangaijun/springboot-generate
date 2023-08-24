package com.light.test;

import lombok.Data;
import com.light.common.exception.BusinessException;
import com.light.common.exception.BusinessExceptionErrorEnum;
import com.light.common.utils.TokenUtil;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/sys")
public class LoginController {
    @Data
    public static class SysUser {
        private String name;
        private String password;
    }

    @RequestMapping(value="/login", method= RequestMethod.POST)
    public Object login(
            @RequestBody SysUser user) {

        if (user.getName() != null && user.getName().equals("admin")
                && user.getPassword() != null && user.getPassword().equals("123456")
        ) {
            return TokenUtil.createToken(1);
        }

        throw new BusinessException(BusinessExceptionErrorEnum.USER_NAME_OR_PASSWORD_ERROR);
    }

    @RequestMapping(value="/getData", method= RequestMethod.POST)
    public Object getData() {
        SysUser suser = new SysUser();
        suser.setName("fnk");
        suser.setPassword("i am a good boy!");

       return "你好！";
    }
}
