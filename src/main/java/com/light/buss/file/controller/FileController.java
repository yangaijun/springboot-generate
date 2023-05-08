package com.light.buss.file.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.light.buss.file.entity.po.FilePO;
import com.light.buss.file.entity.vo.FileVO;
import com.light.buss.file.service.FileService;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/File")
public class FileController {
	@Autowired
	private FileService fileService;

	/**
     *添加
     **/
    @RequestMapping(value="/save", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object saveFile(
            @RequestBody FilePO file) {
        return fileService.save(file);
    }

    /**
     *修改
     **/
    @RequestMapping(value="/update", method=RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object updateFile(
            @RequestBody FilePO file) {
        return fileService.updateById(file);
    }

	/**
	 *添加或修改 
	 **/
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Object saveOrUpdateFile(
    		@RequestBody FilePO file) {
        return fileService.saveOrUpdate(file);
    }

    /**
	 *查找
	 **/
	@RequestMapping(value="/search", method = RequestMethod.POST)
    public Object searchFile(@RequestBody FileVO params) {
        FilePO filePO = new FilePO();
        BeanUtils.copyProperties(params, filePO);
        Page<FilePO> page = new Page<>(params.getPageNo(), params.getPageSize());

        QueryWrapper<FilePO> queryWrapper = new QueryWrapper<>(filePO);

        return fileService.page(page, queryWrapper);
    }
    
	/**
	 *通过id删除
	 **/
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	@RequestMapping(value="/removeById/{id}", method=RequestMethod.POST)
    public Object removeFileById(@PathVariable Integer id) {
        return fileService.removeById(id);
    }

    /**
     *删除
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/remove", method=RequestMethod.POST)
    public Object removeFile(@RequestBody FilePO file) {
        return fileService.remove(new QueryWrapper<>(file));
    }

    /**
     *删除多条
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @RequestMapping(value="/removeByIds", method=RequestMethod.POST)
    public Object removeFileByIds(@RequestBody List<Integer> ids) {
        return fileService.removeByIds(ids);
    }
}
