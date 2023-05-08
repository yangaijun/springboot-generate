package com.light.buss.masterplatepage.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.light.buss.masterplatepage.entity.po.MasterplatePagePO;
import com.light.buss.masterplatepage.mapper.MasterplatePageMapper;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Service
public class MasterplatePageService extends ServiceImpl<MasterplatePageMapper, MasterplatePagePO> {

    @Autowired
    MasterplatePageMapper masterplatePageMapper;

}
