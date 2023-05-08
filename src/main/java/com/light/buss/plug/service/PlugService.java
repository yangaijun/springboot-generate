package com.light.buss.plug.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.light.buss.plug.entity.po.PlugPO;
import com.light.buss.plug.mapper.PlugMapper;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Service
public class PlugService extends ServiceImpl<PlugMapper, PlugPO> {

    @Autowired
    PlugMapper plugMapper;

}
