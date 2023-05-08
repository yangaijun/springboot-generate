package com.light.buss.plug.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.light.buss.plug.entity.po.PlugPO;
import com.light.buss.plug.entity.vo.PlugVO;
import com.light.buss.plug.service.PlugService;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/Plug")
public class PlugController {
	@Autowired
	private PlugService plugService;

	/**
     *添加
     **/
    @RequestMapping(value="/save", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object savePlug(
            @RequestBody PlugPO plug) {
        return plugService.save(plug);
    }

    /**
     *修改
     **/
    @RequestMapping(value="/update", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object updatePlug(
            @RequestBody PlugPO plug) {
        return plugService.updateById(plug);
    }

	/**
	 *添加或修改 
	 **/
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object saveOrUpdatePlug(
    		@RequestBody PlugPO plug) {
        return plugService.saveOrUpdate(plug);
    }

    /**
	 *查找
	 **/
	@RequestMapping(value="/search", method = RequestMethod.POST)
    public Object searchPlug(@RequestBody PlugVO params) {
        PlugPO plugPO = new PlugPO();
        BeanUtils.copyProperties(params, plugPO);
        Page<PlugPO> page = new Page<>(params.getPageNo(), params.getPageSize());

        QueryWrapper<PlugPO> queryWrapper = new QueryWrapper<>(plugPO);

        return plugService.page(page, queryWrapper);
    }
    
	/**
	 *通过id删除
	 **/
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	@RequestMapping(value="/removeById/{id}", method=RequestMethod.POST)
    public Object removePlugById(@PathVariable Integer id) {
        return plugService.removeById(id);
    }

    /**
     *删除
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/remove", method=RequestMethod.POST)
    public Object removePlug(@RequestBody PlugPO plug) {
        return plugService.remove(new QueryWrapper<>(plug));
    }

    /**
     *删除多条
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/removeByIds", method=RequestMethod.POST)
    public Object removePlugByIds(@RequestBody List<Integer> ids) {
        return plugService.removeByIds(ids);
    }
}
