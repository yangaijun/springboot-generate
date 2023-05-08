package com.light.buss.plugcomment.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.light.buss.plugcomment.entity.po.PlugCommentPO;
import com.light.buss.plugcomment.entity.vo.PlugCommentVO;
import com.light.buss.plugcomment.service.PlugCommentService;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/PlugComment")
public class PlugCommentController {
	@Autowired
	private PlugCommentService plugCommentService;

	/**
     *添加
     **/
    @RequestMapping(value="/save", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object savePlugComment(
            @RequestBody PlugCommentPO plugComment) {
        return plugCommentService.save(plugComment);
    }

    /**
     *修改
     **/
    @RequestMapping(value="/update", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object updatePlugComment(
            @RequestBody PlugCommentPO plugComment) {
        return plugCommentService.updateById(plugComment);
    }

	/**
	 *添加或修改 
	 **/
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object saveOrUpdatePlugComment(
    		@RequestBody PlugCommentPO plugComment) {
        return plugCommentService.saveOrUpdate(plugComment);
    }

    /**
	 *查找
	 **/
	@RequestMapping(value="/search", method = RequestMethod.POST)
    public Object searchPlugComment(@RequestBody PlugCommentVO params) {
        PlugCommentPO plugCommentPO = new PlugCommentPO();
        BeanUtils.copyProperties(params, plugCommentPO);
        Page<PlugCommentPO> page = new Page<>(params.getPageNo(), params.getPageSize());

        QueryWrapper<PlugCommentPO> queryWrapper = new QueryWrapper<>(plugCommentPO);

        return plugCommentService.page(page, queryWrapper);
    }
    
	/**
	 *通过id删除
	 **/
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	@RequestMapping(value="/removeById/{id}", method=RequestMethod.POST)
    public Object removePlugCommentById(@PathVariable Integer id) {
        return plugCommentService.removeById(id);
    }

    /**
     *删除
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/remove", method=RequestMethod.POST)
    public Object removePlugComment(@RequestBody PlugCommentPO plugComment) {
        return plugCommentService.remove(new QueryWrapper<>(plugComment));
    }

    /**
     *删除多条
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/removeByIds", method=RequestMethod.POST)
    public Object removePlugCommentByIds(@RequestBody List<Integer> ids) {
        return plugCommentService.removeByIds(ids);
    }
}
