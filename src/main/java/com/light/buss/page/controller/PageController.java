package com.light.buss.page.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.light.buss.page.entity.po.PagePO;
import com.light.buss.page.entity.vo.PageVO;
import com.light.buss.page.service.PageService;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/Page")
public class PageController {
	@Autowired
	private PageService pageService;

	/**
     *添加
     **/
    @RequestMapping(value="/save", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object savePage(
            @RequestBody PagePO page) {
        return pageService.save(page);
    }

    /**
     *修改
     **/
    @RequestMapping(value="/update", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object updatePage(
            @RequestBody PagePO page) {
        return pageService.updateById(page);
    }

	/**
	 *添加或修改 
	 **/
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object saveOrUpdatePage(
    		@RequestBody PagePO page) {
        return pageService.saveOrUpdate(page);
    }

    /**
	 *查找
	 **/
	@RequestMapping(value="/search", method = RequestMethod.POST)
    public Object searchPage(@RequestBody PageVO params) {
        PagePO pagePO = new PagePO();
        BeanUtils.copyProperties(params, pagePO);
        Page<PagePO> page = new Page<>(params.getPageNo(), params.getPageSize());

        QueryWrapper<PagePO> queryWrapper = new QueryWrapper<>(pagePO);

        return pageService.page(page, queryWrapper);
    }
    
	/**
	 *通过id删除
	 **/
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	@RequestMapping(value="/removeById/{id}", method=RequestMethod.POST)
    public Object removePageById(@PathVariable Integer id) {
        return pageService.removeById(id);
    }

    /**
     *删除
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/remove", method=RequestMethod.POST)
    public Object removePage(@RequestBody PagePO page) {
        return pageService.remove(new QueryWrapper<>(page));
    }

    /**
     *删除多条
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/removeByIds", method=RequestMethod.POST)
    public Object removePageByIds(@RequestBody List<Integer> ids) {
        return pageService.removeByIds(ids);
    }
}
