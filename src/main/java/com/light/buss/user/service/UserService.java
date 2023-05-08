package com.light.buss.user.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.light.buss.user.entity.po.UserPO;
import com.light.buss.user.mapper.UserMapper;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Service
public class UserService extends ServiceImpl<UserMapper, UserPO> {

    @Autowired
    UserMapper userMapper;

}
