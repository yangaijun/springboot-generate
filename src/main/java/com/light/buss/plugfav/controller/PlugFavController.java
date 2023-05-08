package com.light.buss.plugfav.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.light.buss.plugfav.entity.po.PlugFavPO;
import com.light.buss.plugfav.entity.vo.PlugFavVO;
import com.light.buss.plugfav.service.PlugFavService;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/PlugFav")
public class PlugFavController {
	@Autowired
	private PlugFavService plugFavService;

	/**
     *添加
     **/
    @RequestMapping(value="/save", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object savePlugFav(
            @RequestBody PlugFavPO plugFav) {
        return plugFavService.save(plugFav);
    }

    /**
     *修改
     **/
    @RequestMapping(value="/update", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object updatePlugFav(
            @RequestBody PlugFavPO plugFav) {
        return plugFavService.updateById(plugFav);
    }

	/**
	 *添加或修改 
	 **/
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object saveOrUpdatePlugFav(
    		@RequestBody PlugFavPO plugFav) {
        return plugFavService.saveOrUpdate(plugFav);
    }

    /**
	 *查找
	 **/
	@RequestMapping(value="/search", method = RequestMethod.POST)
    public Object searchPlugFav(@RequestBody PlugFavVO params) {
        PlugFavPO plugFavPO = new PlugFavPO();
        BeanUtils.copyProperties(params, plugFavPO);
        Page<PlugFavPO> page = new Page<>(params.getPageNo(), params.getPageSize());

        QueryWrapper<PlugFavPO> queryWrapper = new QueryWrapper<>(plugFavPO);

        return plugFavService.page(page, queryWrapper);
    }
    
	/**
	 *通过id删除
	 **/
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	@RequestMapping(value="/removeById/{id}", method=RequestMethod.POST)
    public Object removePlugFavById(@PathVariable Integer id) {
        return plugFavService.removeById(id);
    }

    /**
     *删除
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/remove", method=RequestMethod.POST)
    public Object removePlugFav(@RequestBody PlugFavPO plugFav) {
        return plugFavService.remove(new QueryWrapper<>(plugFav));
    }

    /**
     *删除多条
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/removeByIds", method=RequestMethod.POST)
    public Object removePlugFavByIds(@RequestBody List<Integer> ids) {
        return plugFavService.removeByIds(ids);
    }
}
