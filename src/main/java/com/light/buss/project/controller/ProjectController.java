package com.light.buss.project.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.light.buss.project.entity.po.ProjectPO;
import com.light.buss.project.entity.vo.ProjectVO;
import com.light.buss.project.service.ProjectService;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/Project")
public class ProjectController {
	@Autowired
	private ProjectService projectService;

	/**
     *添加
     **/
    @RequestMapping(value="/save", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object saveProject(
            @RequestBody ProjectPO project) {
        return projectService.save(project);
    }

    /**
     *修改
     **/
    @RequestMapping(value="/update", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object updateProject(
            @RequestBody ProjectPO project) {
        return projectService.updateById(project);
    }

	/**
	 *添加或修改 
	 **/
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object saveOrUpdateProject(
    		@RequestBody ProjectPO project) {
        return projectService.saveOrUpdate(project);
    }

    /**
	 *查找
	 **/
	@RequestMapping(value="/search", method = RequestMethod.POST)
    public Object searchProject(@RequestBody ProjectVO params) {
        ProjectPO projectPO = new ProjectPO();
        BeanUtils.copyProperties(params, projectPO);
        Page<ProjectPO> page = new Page<>(params.getPageNo(), params.getPageSize());

        QueryWrapper<ProjectPO> queryWrapper = new QueryWrapper<>(projectPO);

        return projectService.page(page, queryWrapper);
    }
    
	/**
	 *通过id删除
	 **/
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	@RequestMapping(value="/removeById/{id}", method=RequestMethod.POST)
    public Object removeProjectById(@PathVariable Integer id) {
        return projectService.removeById(id);
    }

    /**
     *删除
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/remove", method=RequestMethod.POST)
    public Object removeProject(@RequestBody ProjectPO project) {
        return projectService.remove(new QueryWrapper<>(project));
    }

    /**
     *删除多条
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/removeByIds", method=RequestMethod.POST)
    public Object removeProjectByIds(@RequestBody List<Integer> ids) {
        return projectService.removeByIds(ids);
    }
}
