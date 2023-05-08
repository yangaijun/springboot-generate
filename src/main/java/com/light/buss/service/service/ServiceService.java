package com.light.buss.service.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.light.buss.service.entity.po.ServicePO;
import com.light.buss.service.mapper.ServiceMapper;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Service
public class ServiceService extends ServiceImpl<ServiceMapper, ServicePO> {

    @Autowired
    ServiceMapper serviceMapper;

}
