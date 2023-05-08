package com.light.buss.component.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.light.buss.component.entity.po.ComponentPO;
import com.light.buss.component.mapper.ComponentMapper;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Service
public class ComponentService extends ServiceImpl<ComponentMapper, ComponentPO> {

    @Autowired
    ComponentMapper componentMapper;

}
