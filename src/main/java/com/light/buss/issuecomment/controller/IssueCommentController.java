package com.light.buss.issuecomment.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.light.buss.issuecomment.entity.po.IssueCommentPO;
import com.light.buss.issuecomment.entity.vo.IssueCommentVO;
import com.light.buss.issuecomment.service.IssueCommentService;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/IssueComment")
public class IssueCommentController {
	@Autowired
	private IssueCommentService issueCommentService;

	/**
     *添加
     **/
    @RequestMapping(value="/save", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object saveIssueComment(
            @RequestBody IssueCommentPO issueComment) {
        return issueCommentService.save(issueComment);
    }

    /**
     *修改
     **/
    @RequestMapping(value="/update", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object updateIssueComment(
            @RequestBody IssueCommentPO issueComment) {
        return issueCommentService.updateById(issueComment);
    }

	/**
	 *添加或修改 
	 **/
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object saveOrUpdateIssueComment(
    		@RequestBody IssueCommentPO issueComment) {
        return issueCommentService.saveOrUpdate(issueComment);
    }

    /**
	 *查找
	 **/
	@RequestMapping(value="/search", method = RequestMethod.POST)
    public Object searchIssueComment(@RequestBody IssueCommentVO params) {
        IssueCommentPO issueCommentPO = new IssueCommentPO();
        BeanUtils.copyProperties(params, issueCommentPO);
        Page<IssueCommentPO> page = new Page<>(params.getPageNo(), params.getPageSize());

        QueryWrapper<IssueCommentPO> queryWrapper = new QueryWrapper<>(issueCommentPO);

        return issueCommentService.page(page, queryWrapper);
    }
    
	/**
	 *通过id删除
	 **/
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	@RequestMapping(value="/removeById/{id}", method=RequestMethod.POST)
    public Object removeIssueCommentById(@PathVariable Integer id) {
        return issueCommentService.removeById(id);
    }

    /**
     *删除
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/remove", method=RequestMethod.POST)
    public Object removeIssueComment(@RequestBody IssueCommentPO issueComment) {
        return issueCommentService.remove(new QueryWrapper<>(issueComment));
    }

    /**
     *删除多条
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/removeByIds", method=RequestMethod.POST)
    public Object removeIssueCommentByIds(@RequestBody List<Integer> ids) {
        return issueCommentService.removeByIds(ids);
    }
}
