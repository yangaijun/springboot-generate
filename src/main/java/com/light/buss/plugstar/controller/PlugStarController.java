package com.light.buss.plugstar.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.light.buss.plugstar.entity.po.PlugStarPO;
import com.light.buss.plugstar.entity.vo.PlugStarVO;
import com.light.buss.plugstar.service.PlugStarService;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/PlugStar")
public class PlugStarController {
	@Autowired
	private PlugStarService plugStarService;

	/**
     *添加
     **/
    @RequestMapping(value="/save", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object savePlugStar(
            @RequestBody PlugStarPO plugStar) {
        return plugStarService.save(plugStar);
    }

    /**
     *修改
     **/
    @RequestMapping(value="/update", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object updatePlugStar(
            @RequestBody PlugStarPO plugStar) {
        return plugStarService.updateById(plugStar);
    }

	/**
	 *添加或修改 
	 **/
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object saveOrUpdatePlugStar(
    		@RequestBody PlugStarPO plugStar) {
        return plugStarService.saveOrUpdate(plugStar);
    }

    /**
	 *查找
	 **/
	@RequestMapping(value="/search", method = RequestMethod.POST)
    public Object searchPlugStar(@RequestBody PlugStarVO params) {
        PlugStarPO plugStarPO = new PlugStarPO();
        BeanUtils.copyProperties(params, plugStarPO);
        Page<PlugStarPO> page = new Page<>(params.getPageNo(), params.getPageSize());

        QueryWrapper<PlugStarPO> queryWrapper = new QueryWrapper<>(plugStarPO);

        return plugStarService.page(page, queryWrapper);
    }
    
	/**
	 *通过id删除
	 **/
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	@RequestMapping(value="/removeById/{id}", method=RequestMethod.POST)
    public Object removePlugStarById(@PathVariable Integer id) {
        return plugStarService.removeById(id);
    }

    /**
     *删除
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/remove", method=RequestMethod.POST)
    public Object removePlugStar(@RequestBody PlugStarPO plugStar) {
        return plugStarService.remove(new QueryWrapper<>(plugStar));
    }

    /**
     *删除多条
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/removeByIds", method=RequestMethod.POST)
    public Object removePlugStarByIds(@RequestBody List<Integer> ids) {
        return plugStarService.removeByIds(ids);
    }
}
