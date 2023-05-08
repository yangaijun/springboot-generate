package com.light.buss.component.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.light.buss.component.entity.po.ComponentPO;
import com.light.buss.component.entity.vo.ComponentVO;
import com.light.buss.component.service.ComponentService;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/Component")
public class ComponentController {
	@Autowired
	private ComponentService componentService;

	/**
     *添加
     **/
    @RequestMapping(value="/save", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object saveComponent(
            @RequestBody ComponentPO component) {
        return componentService.save(component);
    }

    /**
     *修改
     **/
    @RequestMapping(value="/update", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object updateComponent(
            @RequestBody ComponentPO component) {
        return componentService.updateById(component);
    }

	/**
	 *添加或修改 
	 **/
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object saveOrUpdateComponent(
    		@RequestBody ComponentPO component) {
        return componentService.saveOrUpdate(component);
    }

    /**
	 *查找
	 **/
	@RequestMapping(value="/search", method = RequestMethod.POST)
    public Object searchComponent(@RequestBody ComponentVO params) {
        ComponentPO componentPO = new ComponentPO();
        BeanUtils.copyProperties(params, componentPO);
        Page<ComponentPO> page = new Page<>(params.getPageNo(), params.getPageSize());

        QueryWrapper<ComponentPO> queryWrapper = new QueryWrapper<>(componentPO);

        return componentService.page(page, queryWrapper);
    }
    
	/**
	 *通过id删除
	 **/
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	@RequestMapping(value="/removeById/{id}", method=RequestMethod.POST)
    public Object removeComponentById(@PathVariable Integer id) {
        return componentService.removeById(id);
    }

    /**
     *删除
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/remove", method=RequestMethod.POST)
    public Object removeComponent(@RequestBody ComponentPO component) {
        return componentService.remove(new QueryWrapper<>(component));
    }

    /**
     *删除多条
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/removeByIds", method=RequestMethod.POST)
    public Object removeComponentByIds(@RequestBody List<Integer> ids) {
        return componentService.removeByIds(ids);
    }
}
