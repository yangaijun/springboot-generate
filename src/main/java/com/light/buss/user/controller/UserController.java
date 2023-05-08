package com.light.buss.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.light.buss.user.entity.po.UserPO;
import com.light.buss.user.entity.vo.UserVO;
import com.light.buss.user.service.UserService;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/User")
public class UserController {
	@Autowired
	private UserService userService;

	/**
     *添加
     **/
    @RequestMapping(value="/save", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object saveUser(
            @RequestBody UserPO user) {
        return userService.save(user);
    }

    /**
     *修改
     **/
    @RequestMapping(value="/update", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object updateUser(
            @RequestBody UserPO user) {
        return userService.updateById(user);
    }

	/**
	 *添加或修改 
	 **/
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object saveOrUpdateUser(
    		@RequestBody UserPO user) {
        return userService.saveOrUpdate(user);
    }

    /**
	 *查找
	 **/
	@RequestMapping(value="/search", method = RequestMethod.POST)
    public Object searchUser(@RequestBody UserVO params) {
        UserPO userPO = new UserPO();
        BeanUtils.copyProperties(params, userPO);
        Page<UserPO> page = new Page<>(params.getPageNo(), params.getPageSize());

        QueryWrapper<UserPO> queryWrapper = new QueryWrapper<>(userPO);

        return userService.page(page, queryWrapper);
    }
    
	/**
	 *通过id删除
	 **/
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	@RequestMapping(value="/removeById/{id}", method=RequestMethod.POST)
    public Object removeUserById(@PathVariable Integer id) {
        return userService.removeById(id);
    }

    /**
     *删除
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/remove", method=RequestMethod.POST)
    public Object removeUser(@RequestBody UserPO user) {
        return userService.remove(new QueryWrapper<>(user));
    }

    /**
     *删除多条
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/removeByIds", method=RequestMethod.POST)
    public Object removeUserByIds(@RequestBody List<Integer> ids) {
        return userService.removeByIds(ids);
    }
}
