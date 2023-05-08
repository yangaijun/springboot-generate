package com.light.buss.nametranslator.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.light.buss.nametranslator.entity.po.NameTranslatorPO;
import com.light.buss.nametranslator.entity.vo.NameTranslatorVO;
import com.light.buss.nametranslator.service.NameTranslatorService;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/NameTranslator")
public class NameTranslatorController {
	@Autowired
	private NameTranslatorService nameTranslatorService;

	/**
     *添加
     **/
    @RequestMapping(value="/save", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object saveNameTranslator(
            @RequestBody NameTranslatorPO nameTranslator) {
        return nameTranslatorService.save(nameTranslator);
    }

    /**
     *修改
     **/
    @RequestMapping(value="/update", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object updateNameTranslator(
            @RequestBody NameTranslatorPO nameTranslator) {
        return nameTranslatorService.updateById(nameTranslator);
    }

	/**
	 *添加或修改 
	 **/
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object saveOrUpdateNameTranslator(
    		@RequestBody NameTranslatorPO nameTranslator) {
        return nameTranslatorService.saveOrUpdate(nameTranslator);
    }

    /**
	 *查找
	 **/
	@RequestMapping(value="/search", method = RequestMethod.POST)
    public Object searchNameTranslator(@RequestBody NameTranslatorVO params) {
        NameTranslatorPO nameTranslatorPO = new NameTranslatorPO();
        BeanUtils.copyProperties(params, nameTranslatorPO);
        Page<NameTranslatorPO> page = new Page<>(params.getPageNo(), params.getPageSize());

        QueryWrapper<NameTranslatorPO> queryWrapper = new QueryWrapper<>(nameTranslatorPO);

        return nameTranslatorService.page(page, queryWrapper);
    }
    
	/**
	 *通过id删除
	 **/
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	@RequestMapping(value="/removeById/{id}", method=RequestMethod.POST)
    public Object removeNameTranslatorById(@PathVariable Integer id) {
        return nameTranslatorService.removeById(id);
    }

    /**
     *删除
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/remove", method=RequestMethod.POST)
    public Object removeNameTranslator(@RequestBody NameTranslatorPO nameTranslator) {
        return nameTranslatorService.remove(new QueryWrapper<>(nameTranslator));
    }

    /**
     *删除多条
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/removeByIds", method=RequestMethod.POST)
    public Object removeNameTranslatorByIds(@RequestBody List<Integer> ids) {
        return nameTranslatorService.removeByIds(ids);
    }
}
