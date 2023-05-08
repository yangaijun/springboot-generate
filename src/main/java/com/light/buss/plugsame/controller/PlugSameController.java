package com.light.buss.plugsame.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.light.buss.plugsame.entity.po.PlugSamePO;
import com.light.buss.plugsame.entity.vo.PlugSameVO;
import com.light.buss.plugsame.service.PlugSameService;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/PlugSame")
public class PlugSameController {
	@Autowired
	private PlugSameService plugSameService;

	/**
     *添加
     **/
    @RequestMapping(value="/save", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object savePlugSame(
            @RequestBody PlugSamePO plugSame) {
        return plugSameService.save(plugSame);
    }

    /**
     *修改
     **/
    @RequestMapping(value="/update", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object updatePlugSame(
            @RequestBody PlugSamePO plugSame) {
        return plugSameService.updateById(plugSame);
    }

	/**
	 *添加或修改 
	 **/
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object saveOrUpdatePlugSame(
    		@RequestBody PlugSamePO plugSame) {
        return plugSameService.saveOrUpdate(plugSame);
    }

    /**
	 *查找
	 **/
	@RequestMapping(value="/search", method = RequestMethod.POST)
    public Object searchPlugSame(@RequestBody PlugSameVO params) {
        PlugSamePO plugSamePO = new PlugSamePO();
        BeanUtils.copyProperties(params, plugSamePO);
        Page<PlugSamePO> page = new Page<>(params.getPageNo(), params.getPageSize());

        QueryWrapper<PlugSamePO> queryWrapper = new QueryWrapper<>(plugSamePO);

        return plugSameService.page(page, queryWrapper);
    }
    
	/**
	 *通过id删除
	 **/
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	@RequestMapping(value="/removeById/{id}", method=RequestMethod.POST)
    public Object removePlugSameById(@PathVariable Integer id) {
        return plugSameService.removeById(id);
    }

    /**
     *删除
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/remove", method=RequestMethod.POST)
    public Object removePlugSame(@RequestBody PlugSamePO plugSame) {
        return plugSameService.remove(new QueryWrapper<>(plugSame));
    }

    /**
     *删除多条
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/removeByIds", method=RequestMethod.POST)
    public Object removePlugSameByIds(@RequestBody List<Integer> ids) {
        return plugSameService.removeByIds(ids);
    }
}
