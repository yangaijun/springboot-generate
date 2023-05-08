package com.light.buss.masterplateproject.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.light.buss.masterplateproject.entity.po.MasterplateProjectPO;
import com.light.buss.masterplateproject.entity.vo.MasterplateProjectVO;
import com.light.buss.masterplateproject.service.MasterplateProjectService;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/MasterplateProject")
public class MasterplateProjectController {
	@Autowired
	private MasterplateProjectService masterplateProjectService;

	/**
     *添加
     **/
    @RequestMapping(value="/save", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object saveMasterplateProject(
            @RequestBody MasterplateProjectPO masterplateProject) {
        return masterplateProjectService.save(masterplateProject);
    }

    /**
     *修改
     **/
    @RequestMapping(value="/update", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object updateMasterplateProject(
            @RequestBody MasterplateProjectPO masterplateProject) {
        return masterplateProjectService.updateById(masterplateProject);
    }

	/**
	 *添加或修改 
	 **/
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object saveOrUpdateMasterplateProject(
    		@RequestBody MasterplateProjectPO masterplateProject) {
        return masterplateProjectService.saveOrUpdate(masterplateProject);
    }

    /**
	 *查找
	 **/
	@RequestMapping(value="/search", method = RequestMethod.POST)
    public Object searchMasterplateProject(@RequestBody MasterplateProjectVO params) {
        MasterplateProjectPO masterplateProjectPO = new MasterplateProjectPO();
        BeanUtils.copyProperties(params, masterplateProjectPO);
        Page<MasterplateProjectPO> page = new Page<>(params.getPageNo(), params.getPageSize());

        QueryWrapper<MasterplateProjectPO> queryWrapper = new QueryWrapper<>(masterplateProjectPO);

        return masterplateProjectService.page(page, queryWrapper);
    }
    
	/**
	 *通过id删除
	 **/
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	@RequestMapping(value="/removeById/{id}", method=RequestMethod.POST)
    public Object removeMasterplateProjectById(@PathVariable Integer id) {
        return masterplateProjectService.removeById(id);
    }

    /**
     *删除
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/remove", method=RequestMethod.POST)
    public Object removeMasterplateProject(@RequestBody MasterplateProjectPO masterplateProject) {
        return masterplateProjectService.remove(new QueryWrapper<>(masterplateProject));
    }

    /**
     *删除多条
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/removeByIds", method=RequestMethod.POST)
    public Object removeMasterplateProjectByIds(@RequestBody List<Integer> ids) {
        return masterplateProjectService.removeByIds(ids);
    }
}
