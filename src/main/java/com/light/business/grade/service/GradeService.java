package com.light.business.grade.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.light.business.grade.entity.po.GradePO;
import com.light.business.grade.mapper.GradeMapper;

/*
 * @Description: 
 * @date: 2023-08-25
 */
@Service
public class GradeService extends ServiceImpl<GradeMapper, GradePO> {

    @Autowired
    GradeMapper gradeMapper;

}
