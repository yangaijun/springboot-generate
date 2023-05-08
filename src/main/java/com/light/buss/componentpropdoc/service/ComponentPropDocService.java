package com.light.buss.componentpropdoc.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.light.buss.componentpropdoc.entity.po.ComponentPropDocPO;
import com.light.buss.componentpropdoc.mapper.ComponentPropDocMapper;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Service
public class ComponentPropDocService extends ServiceImpl<ComponentPropDocMapper, ComponentPropDocPO> {

    @Autowired
    ComponentPropDocMapper componentPropDocMapper;

}
