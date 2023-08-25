package com.light.business.student.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.light.business.student.entity.po.StudentPO;
import com.light.business.student.mapper.StudentMapper;

/*
 * @Description: 
 * @date: 2023-08-25
 */
@Service
public class StudentService extends ServiceImpl<StudentMapper, StudentPO> {

    @Autowired
    StudentMapper studentMapper;

}
