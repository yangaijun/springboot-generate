package com.light.buss.initcode.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.light.buss.initcode.entity.po.InitCodePO;
import com.light.buss.initcode.entity.vo.InitCodeVO;
import com.light.buss.initcode.service.InitCodeService;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/InitCode")
public class InitCodeController {
	@Autowired
	private InitCodeService initCodeService;

	/**
     *添加
     **/
    @RequestMapping(value="/save", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object saveInitCode(
            @RequestBody InitCodePO initCode) {
        return initCodeService.save(initCode);
    }

    /**
     *修改
     **/
    @RequestMapping(value="/update", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object updateInitCode(
            @RequestBody InitCodePO initCode) {
        return initCodeService.updateById(initCode);
    }

	/**
	 *添加或修改 
	 **/
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object saveOrUpdateInitCode(
    		@RequestBody InitCodePO initCode) {
        return initCodeService.saveOrUpdate(initCode);
    }

    /**
	 *查找
	 **/
	@RequestMapping(value="/search", method = RequestMethod.POST)
    public Object searchInitCode(@RequestBody InitCodeVO params) {
        InitCodePO initCodePO = new InitCodePO();
        BeanUtils.copyProperties(params, initCodePO);
        Page<InitCodePO> page = new Page<>(params.getPageNo(), params.getPageSize());

        QueryWrapper<InitCodePO> queryWrapper = new QueryWrapper<>(initCodePO);

        return initCodeService.page(page, queryWrapper);
    }
    
	/**
	 *通过id删除
	 **/
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	@RequestMapping(value="/removeById/{id}", method=RequestMethod.POST)
    public Object removeInitCodeById(@PathVariable Integer id) {
        return initCodeService.removeById(id);
    }

    /**
     *删除
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/remove", method=RequestMethod.POST)
    public Object removeInitCode(@RequestBody InitCodePO initCode) {
        return initCodeService.remove(new QueryWrapper<>(initCode));
    }

    /**
     *删除多条
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/removeByIds", method=RequestMethod.POST)
    public Object removeInitCodeByIds(@RequestBody List<Integer> ids) {
        return initCodeService.removeByIds(ids);
    }
}
