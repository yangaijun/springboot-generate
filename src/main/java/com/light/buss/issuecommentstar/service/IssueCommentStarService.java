package com.light.buss.issuecommentstar.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.light.buss.issuecommentstar.entity.po.IssueCommentStarPO;
import com.light.buss.issuecommentstar.mapper.IssueCommentStarMapper;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Service
public class IssueCommentStarService extends ServiceImpl<IssueCommentStarMapper, IssueCommentStarPO> {

    @Autowired
    IssueCommentStarMapper issueCommentStarMapper;

}
