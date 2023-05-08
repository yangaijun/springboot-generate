package com.light.buss.issue.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.light.buss.issue.entity.po.IssuePO;
import com.light.buss.issue.mapper.IssueMapper;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Service
public class IssueService extends ServiceImpl<IssueMapper, IssuePO> {

    @Autowired
    IssueMapper issueMapper;

}
