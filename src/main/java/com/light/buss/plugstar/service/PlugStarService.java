package com.light.buss.plugstar.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.light.buss.plugstar.entity.po.PlugStarPO;
import com.light.buss.plugstar.mapper.PlugStarMapper;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Service
public class PlugStarService extends ServiceImpl<PlugStarMapper, PlugStarPO> {

    @Autowired
    PlugStarMapper plugStarMapper;

}
