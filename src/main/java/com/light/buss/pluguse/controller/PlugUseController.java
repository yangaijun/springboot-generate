package com.light.buss.pluguse.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.light.buss.pluguse.entity.po.PlugUsePO;
import com.light.buss.pluguse.entity.vo.PlugUseVO;
import com.light.buss.pluguse.service.PlugUseService;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/PlugUse")
public class PlugUseController {
	@Autowired
	private PlugUseService plugUseService;

	/**
     *添加
     **/
    @RequestMapping(value="/save", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object savePlugUse(
            @RequestBody PlugUsePO plugUse) {
        return plugUseService.save(plugUse);
    }

    /**
     *修改
     **/
    @RequestMapping(value="/update", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object updatePlugUse(
            @RequestBody PlugUsePO plugUse) {
        return plugUseService.updateById(plugUse);
    }

	/**
	 *添加或修改 
	 **/
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object saveOrUpdatePlugUse(
    		@RequestBody PlugUsePO plugUse) {
        return plugUseService.saveOrUpdate(plugUse);
    }

    /**
	 *查找
	 **/
	@RequestMapping(value="/search", method = RequestMethod.POST)
    public Object searchPlugUse(@RequestBody PlugUseVO params) {
        PlugUsePO plugUsePO = new PlugUsePO();
        BeanUtils.copyProperties(params, plugUsePO);
        Page<PlugUsePO> page = new Page<>(params.getPageNo(), params.getPageSize());

        QueryWrapper<PlugUsePO> queryWrapper = new QueryWrapper<>(plugUsePO);

        return plugUseService.page(page, queryWrapper);
    }
    
	/**
	 *通过id删除
	 **/
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	@RequestMapping(value="/removeById/{id}", method=RequestMethod.POST)
    public Object removePlugUseById(@PathVariable Integer id) {
        return plugUseService.removeById(id);
    }

    /**
     *删除
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/remove", method=RequestMethod.POST)
    public Object removePlugUse(@RequestBody PlugUsePO plugUse) {
        return plugUseService.remove(new QueryWrapper<>(plugUse));
    }

    /**
     *删除多条
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/removeByIds", method=RequestMethod.POST)
    public Object removePlugUseByIds(@RequestBody List<Integer> ids) {
        return plugUseService.removeByIds(ids);
    }
}
