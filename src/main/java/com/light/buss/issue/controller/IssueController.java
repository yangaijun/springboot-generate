package com.light.buss.issue.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.light.buss.issue.entity.po.IssuePO;
import com.light.buss.issue.entity.vo.IssueVO;
import com.light.buss.issue.service.IssueService;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/Issue")
public class IssueController {
	@Autowired
	private IssueService issueService;

	/**
     *添加
     **/
    @RequestMapping(value="/save", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object saveIssue(
            @RequestBody IssuePO issue) {
        return issueService.save(issue);
    }

    /**
     *修改
     **/
    @RequestMapping(value="/update", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object updateIssue(
            @RequestBody IssuePO issue) {
        return issueService.updateById(issue);
    }

	/**
	 *添加或修改 
	 **/
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object saveOrUpdateIssue(
    		@RequestBody IssuePO issue) {
        return issueService.saveOrUpdate(issue);
    }

    /**
	 *查找
	 **/
	@RequestMapping(value="/search", method = RequestMethod.POST)
    public Object searchIssue(@RequestBody IssueVO params) {
        IssuePO issuePO = new IssuePO();
        BeanUtils.copyProperties(params, issuePO);
        Page<IssuePO> page = new Page<>(params.getPageNo(), params.getPageSize());

        QueryWrapper<IssuePO> queryWrapper = new QueryWrapper<>(issuePO);

        return issueService.page(page, queryWrapper);
    }
    
	/**
	 *通过id删除
	 **/
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	@RequestMapping(value="/removeById/{id}", method=RequestMethod.POST)
    public Object removeIssueById(@PathVariable Integer id) {
        return issueService.removeById(id);
    }

    /**
     *删除
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/remove", method=RequestMethod.POST)
    public Object removeIssue(@RequestBody IssuePO issue) {
        return issueService.remove(new QueryWrapper<>(issue));
    }

    /**
     *删除多条
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/removeByIds", method=RequestMethod.POST)
    public Object removeIssueByIds(@RequestBody List<Integer> ids) {
        return issueService.removeByIds(ids);
    }
}
