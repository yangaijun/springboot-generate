package com.light.business.student.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.light.business.student.entity.po.StudentPO;
import com.light.business.student.entity.vo.StudentVO;
import com.light.business.student.service.StudentService;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/student")
public class StudentController {
	@Autowired
	private StudentService studentService;

	/**
     *添加
     **/
    @RequestMapping(value="/save", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object saveStudent(
            @RequestBody StudentPO student) {
        return studentService.save(student);
    }

    /**
     *修改
     **/
    @RequestMapping(value="/update", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object updateStudent(
            @RequestBody StudentPO student) {
        return studentService.updateById(student);
    }

	/**
	 *添加或修改 
	 **/
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object saveOrUpdateStudent(
    		@RequestBody StudentPO student) {
        return studentService.saveOrUpdate(student);
    }

    /**
	 *查找
	 **/
	@RequestMapping(value="/search", method = RequestMethod.POST)
    public Object searchStudent(@RequestBody StudentVO params) {
        StudentPO studentPO = new StudentPO();
        BeanUtils.copyProperties(params, studentPO);
        Page<StudentPO> page = new Page<>(params.getPageNo(), params.getPageSize());

        QueryWrapper<StudentPO> queryWrapper = new QueryWrapper<>(studentPO);

        return studentService.page(page, queryWrapper);
    }
    
	/**
	 *通过id删除
	 **/
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	@RequestMapping(value="/removeById/{id}", method=RequestMethod.POST)
    public Object removeStudentById(@PathVariable Integer id) {
        return studentService.removeById(id);
    }

    /**
     *删除
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/remove", method=RequestMethod.POST)
    public Object removeStudent(@RequestBody StudentPO student) {
        return studentService.remove(new QueryWrapper<>(student));
    }

    /**
     *删除多条
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/removeByIds", method=RequestMethod.POST)
    public Object removeStudentByIds(@RequestBody List<Integer> ids) {
        return studentService.removeByIds(ids);
    }
}
