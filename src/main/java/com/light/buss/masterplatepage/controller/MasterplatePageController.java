package com.light.buss.masterplatepage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.light.buss.masterplatepage.entity.po.MasterplatePagePO;
import com.light.buss.masterplatepage.entity.vo.MasterplatePageVO;
import com.light.buss.masterplatepage.service.MasterplatePageService;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/MasterplatePage")
public class MasterplatePageController {
	@Autowired
	private MasterplatePageService masterplatePageService;

	/**
     *添加
     **/
    @RequestMapping(value="/save", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object saveMasterplatePage(
            @RequestBody MasterplatePagePO masterplatePage) {
        return masterplatePageService.save(masterplatePage);
    }

    /**
     *修改
     **/
    @RequestMapping(value="/update", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object updateMasterplatePage(
            @RequestBody MasterplatePagePO masterplatePage) {
        return masterplatePageService.updateById(masterplatePage);
    }

	/**
	 *添加或修改 
	 **/
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object saveOrUpdateMasterplatePage(
    		@RequestBody MasterplatePagePO masterplatePage) {
        return masterplatePageService.saveOrUpdate(masterplatePage);
    }

    /**
	 *查找
	 **/
	@RequestMapping(value="/search", method = RequestMethod.POST)
    public Object searchMasterplatePage(@RequestBody MasterplatePageVO params) {
        MasterplatePagePO masterplatePagePO = new MasterplatePagePO();
        BeanUtils.copyProperties(params, masterplatePagePO);
        Page<MasterplatePagePO> page = new Page<>(params.getPageNo(), params.getPageSize());

        QueryWrapper<MasterplatePagePO> queryWrapper = new QueryWrapper<>(masterplatePagePO);

        return masterplatePageService.page(page, queryWrapper);
    }
    
	/**
	 *通过id删除
	 **/
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	@RequestMapping(value="/removeById/{id}", method=RequestMethod.POST)
    public Object removeMasterplatePageById(@PathVariable Integer id) {
        return masterplatePageService.removeById(id);
    }

    /**
     *删除
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/remove", method=RequestMethod.POST)
    public Object removeMasterplatePage(@RequestBody MasterplatePagePO masterplatePage) {
        return masterplatePageService.remove(new QueryWrapper<>(masterplatePage));
    }

    /**
     *删除多条
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/removeByIds", method=RequestMethod.POST)
    public Object removeMasterplatePageByIds(@RequestBody List<Integer> ids) {
        return masterplatePageService.removeByIds(ids);
    }
}
