package com.light.buss.project.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.light.buss.project.entity.po.ProjectPO;
import com.light.buss.project.mapper.ProjectMapper;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Service
public class ProjectService extends ServiceImpl<ProjectMapper, ProjectPO> {

    @Autowired
    ProjectMapper projectMapper;

}
