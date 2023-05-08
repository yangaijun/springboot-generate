package com.light.buss.pluguse.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.light.buss.pluguse.entity.po.PlugUsePO;
import com.light.buss.pluguse.mapper.PlugUseMapper;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Service
public class PlugUseService extends ServiceImpl<PlugUseMapper, PlugUsePO> {

    @Autowired
    PlugUseMapper plugUseMapper;

}
