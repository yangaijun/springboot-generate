package com.light.buss.page.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.light.buss.page.entity.po.PagePO;
import com.light.buss.page.mapper.PageMapper;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Service
public class PageService extends ServiceImpl<PageMapper, PagePO> {

    @Autowired
    PageMapper pageMapper;

}
