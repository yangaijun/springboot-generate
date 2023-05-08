package com.light.buss.masterplateproject.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.light.buss.masterplateproject.entity.po.MasterplateProjectPO;
import com.light.buss.masterplateproject.mapper.MasterplateProjectMapper;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Service
public class MasterplateProjectService extends ServiceImpl<MasterplateProjectMapper, MasterplateProjectPO> {

    @Autowired
    MasterplateProjectMapper masterplateProjectMapper;

}
