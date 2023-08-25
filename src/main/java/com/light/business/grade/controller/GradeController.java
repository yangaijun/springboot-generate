package com.light.business.grade.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.light.business.grade.entity.po.GradePO;
import com.light.business.grade.entity.vo.GradeVO;
import com.light.business.grade.service.GradeService;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/grade")
public class GradeController {
	@Autowired
	private GradeService gradeService;

	/**
     *添加
     **/
    @RequestMapping(value="/save", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object saveGrade(
            @RequestBody GradePO grade) {
        return gradeService.save(grade);
    }

    /**
     *修改
     **/
    @RequestMapping(value="/update", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object updateGrade(
            @RequestBody GradePO grade) {
        return gradeService.updateById(grade);
    }

	/**
	 *添加或修改 
	 **/
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object saveOrUpdateGrade(
    		@RequestBody GradePO grade) {
        return gradeService.saveOrUpdate(grade);
    }

    /**
	 *查找
	 **/
	@RequestMapping(value="/search", method = RequestMethod.POST)
    public Object searchGrade(@RequestBody GradeVO params) {
        GradePO gradePO = new GradePO();
        BeanUtils.copyProperties(params, gradePO);
        Page<GradePO> page = new Page<>(params.getPageNo(), params.getPageSize());

        QueryWrapper<GradePO> queryWrapper = new QueryWrapper<>(gradePO);

        return gradeService.page(page, queryWrapper);
    }
    
	/**
	 *通过id删除
	 **/
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	@RequestMapping(value="/removeById/{id}", method=RequestMethod.POST)
    public Object removeGradeById(@PathVariable Integer id) {
        return gradeService.removeById(id);
    }

    /**
     *删除
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/remove", method=RequestMethod.POST)
    public Object removeGrade(@RequestBody GradePO grade) {
        return gradeService.remove(new QueryWrapper<>(grade));
    }

    /**
     *删除多条
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/removeByIds", method=RequestMethod.POST)
    public Object removeGradeByIds(@RequestBody List<Integer> ids) {
        return gradeService.removeByIds(ids);
    }
}
