package com.light.buss.file.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.light.buss.file.entity.po.FilePO;
import com.light.buss.file.mapper.FileMapper;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Service
public class FileService extends ServiceImpl<FileMapper, FilePO> {

    @Autowired
    FileMapper fileMapper;

}
