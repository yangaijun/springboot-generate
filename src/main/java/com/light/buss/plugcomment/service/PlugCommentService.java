package com.light.buss.plugcomment.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.light.buss.plugcomment.entity.po.PlugCommentPO;
import com.light.buss.plugcomment.mapper.PlugCommentMapper;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Service
public class PlugCommentService extends ServiceImpl<PlugCommentMapper, PlugCommentPO> {

    @Autowired
    PlugCommentMapper plugCommentMapper;

}
