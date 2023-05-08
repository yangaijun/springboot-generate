package com.light.buss.plugsame.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.light.buss.plugsame.entity.po.PlugSamePO;
import com.light.buss.plugsame.mapper.PlugSameMapper;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Service
public class PlugSameService extends ServiceImpl<PlugSameMapper, PlugSamePO> {

    @Autowired
    PlugSameMapper plugSameMapper;

}
