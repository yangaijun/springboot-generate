package com.light.buss.service.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.light.buss.service.entity.po.ServicePO;
import com.light.buss.service.entity.vo.ServiceVO;
import com.light.buss.service.service.ServiceService;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/Service")
public class ServiceController {
	@Autowired
	private ServiceService serviceService;

	/**
     *添加
     **/
    @RequestMapping(value="/save", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object saveService(
            @RequestBody ServicePO service) {
        return serviceService.save(service);
    }

    /**
     *修改
     **/
    @RequestMapping(value="/update", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object updateService(
            @RequestBody ServicePO service) {
        return serviceService.updateById(service);
    }

	/**
	 *添加或修改 
	 **/
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object saveOrUpdateService(
    		@RequestBody ServicePO service) {
        return serviceService.saveOrUpdate(service);
    }

    /**
	 *查找
	 **/
	@RequestMapping(value="/search", method = RequestMethod.POST)
    public Object searchService(@RequestBody ServiceVO params) {
        ServicePO servicePO = new ServicePO();
        BeanUtils.copyProperties(params, servicePO);
        Page<ServicePO> page = new Page<>(params.getPageNo(), params.getPageSize());

        QueryWrapper<ServicePO> queryWrapper = new QueryWrapper<>(servicePO);

        return serviceService.page(page, queryWrapper);
    }
    
	/**
	 *通过id删除
	 **/
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	@RequestMapping(value="/removeById/{id}", method=RequestMethod.POST)
    public Object removeServiceById(@PathVariable Integer id) {
        return serviceService.removeById(id);
    }

    /**
     *删除
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/remove", method=RequestMethod.POST)
    public Object removeService(@RequestBody ServicePO service) {
        return serviceService.remove(new QueryWrapper<>(service));
    }

    /**
     *删除多条
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/removeByIds", method=RequestMethod.POST)
    public Object removeServiceByIds(@RequestBody List<Integer> ids) {
        return serviceService.removeByIds(ids);
    }
}
