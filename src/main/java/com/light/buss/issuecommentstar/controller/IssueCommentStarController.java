package com.light.buss.issuecommentstar.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.light.buss.issuecommentstar.entity.po.IssueCommentStarPO;
import com.light.buss.issuecommentstar.entity.vo.IssueCommentStarVO;
import com.light.buss.issuecommentstar.service.IssueCommentStarService;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/IssueCommentStar")
public class IssueCommentStarController {
	@Autowired
	private IssueCommentStarService issueCommentStarService;

	/**
     *添加
     **/
    @RequestMapping(value="/save", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object saveIssueCommentStar(
            @RequestBody IssueCommentStarPO issueCommentStar) {
        return issueCommentStarService.save(issueCommentStar);
    }

    /**
     *修改
     **/
    @RequestMapping(value="/update", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object updateIssueCommentStar(
            @RequestBody IssueCommentStarPO issueCommentStar) {
        return issueCommentStarService.updateById(issueCommentStar);
    }

	/**
	 *添加或修改 
	 **/
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object saveOrUpdateIssueCommentStar(
    		@RequestBody IssueCommentStarPO issueCommentStar) {
        return issueCommentStarService.saveOrUpdate(issueCommentStar);
    }

    /**
	 *查找
	 **/
	@RequestMapping(value="/search", method = RequestMethod.POST)
    public Object searchIssueCommentStar(@RequestBody IssueCommentStarVO params) {
        IssueCommentStarPO issueCommentStarPO = new IssueCommentStarPO();
        BeanUtils.copyProperties(params, issueCommentStarPO);
        Page<IssueCommentStarPO> page = new Page<>(params.getPageNo(), params.getPageSize());

        QueryWrapper<IssueCommentStarPO> queryWrapper = new QueryWrapper<>(issueCommentStarPO);

        return issueCommentStarService.page(page, queryWrapper);
    }
    
	/**
	 *通过id删除
	 **/
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	@RequestMapping(value="/removeById/{id}", method=RequestMethod.POST)
    public Object removeIssueCommentStarById(@PathVariable Integer id) {
        return issueCommentStarService.removeById(id);
    }

    /**
     *删除
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/remove", method=RequestMethod.POST)
    public Object removeIssueCommentStar(@RequestBody IssueCommentStarPO issueCommentStar) {
        return issueCommentStarService.remove(new QueryWrapper<>(issueCommentStar));
    }

    /**
     *删除多条
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/removeByIds", method=RequestMethod.POST)
    public Object removeIssueCommentStarByIds(@RequestBody List<Integer> ids) {
        return issueCommentStarService.removeByIds(ids);
    }
}
