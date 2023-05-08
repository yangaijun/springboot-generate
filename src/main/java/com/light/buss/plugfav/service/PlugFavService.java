package com.light.buss.plugfav.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.light.buss.plugfav.entity.po.PlugFavPO;
import com.light.buss.plugfav.mapper.PlugFavMapper;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Service
public class PlugFavService extends ServiceImpl<PlugFavMapper, PlugFavPO> {

    @Autowired
    PlugFavMapper plugFavMapper;

}
