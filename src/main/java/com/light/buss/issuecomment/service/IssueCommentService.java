package com.light.buss.issuecomment.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.light.buss.issuecomment.entity.po.IssueCommentPO;
import com.light.buss.issuecomment.mapper.IssueCommentMapper;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Service
public class IssueCommentService extends ServiceImpl<IssueCommentMapper, IssueCommentPO> {

    @Autowired
    IssueCommentMapper issueCommentMapper;

}
