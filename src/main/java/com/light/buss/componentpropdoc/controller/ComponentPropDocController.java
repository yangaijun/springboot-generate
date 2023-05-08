package com.light.buss.componentpropdoc.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.light.buss.componentpropdoc.entity.po.ComponentPropDocPO;
import com.light.buss.componentpropdoc.entity.vo.ComponentPropDocVO;
import com.light.buss.componentpropdoc.service.ComponentPropDocService;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/ComponentPropDoc")
public class ComponentPropDocController {
	@Autowired
	private ComponentPropDocService componentPropDocService;

	/**
     *添加
     **/
    @RequestMapping(value="/save", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object saveComponentPropDoc(
            @RequestBody ComponentPropDocPO componentPropDoc) {
        return componentPropDocService.save(componentPropDoc);
    }

    /**
     *修改
     **/
    @RequestMapping(value="/update", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object updateComponentPropDoc(
            @RequestBody ComponentPropDocPO componentPropDoc) {
        return componentPropDocService.updateById(componentPropDoc);
    }

	/**
	 *添加或修改 
	 **/
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object saveOrUpdateComponentPropDoc(
    		@RequestBody ComponentPropDocPO componentPropDoc) {
        return componentPropDocService.saveOrUpdate(componentPropDoc);
    }

    /**
	 *查找
	 **/
	@RequestMapping(value="/search", method = RequestMethod.POST)
    public Object searchComponentPropDoc(@RequestBody ComponentPropDocVO params) {
        ComponentPropDocPO componentPropDocPO = new ComponentPropDocPO();
        BeanUtils.copyProperties(params, componentPropDocPO);
        Page<ComponentPropDocPO> page = new Page<>(params.getPageNo(), params.getPageSize());

        QueryWrapper<ComponentPropDocPO> queryWrapper = new QueryWrapper<>(componentPropDocPO);

        return componentPropDocService.page(page, queryWrapper);
    }
    
	/**
	 *通过id删除
	 **/
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	@RequestMapping(value="/removeById/{id}", method=RequestMethod.POST)
    public Object removeComponentPropDocById(@PathVariable Integer id) {
        return componentPropDocService.removeById(id);
    }

    /**
     *删除
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/remove", method=RequestMethod.POST)
    public Object removeComponentPropDoc(@RequestBody ComponentPropDocPO componentPropDoc) {
        return componentPropDocService.remove(new QueryWrapper<>(componentPropDoc));
    }

    /**
     *删除多条
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/removeByIds", method=RequestMethod.POST)
    public Object removeComponentPropDocByIds(@RequestBody List<Integer> ids) {
        return componentPropDocService.removeByIds(ids);
    }
}
