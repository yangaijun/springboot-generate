package com.light.buss.nametranslator.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.light.buss.nametranslator.entity.po.NameTranslatorPO;
import com.light.buss.nametranslator.mapper.NameTranslatorMapper;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Service
public class NameTranslatorService extends ServiceImpl<NameTranslatorMapper, NameTranslatorPO> {

    @Autowired
    NameTranslatorMapper nameTranslatorMapper;

}
