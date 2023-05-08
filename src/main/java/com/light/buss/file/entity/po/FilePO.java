package com.light.buss.file.entity.po;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Data
@TableName(value = "file")
public class FilePO {
    /*
    *
    */
    @TableId
    private Integer fileId;
    /*
    *没有parentId
    */
    private Integer parentId;
    /*
    *
    */
    private String fileName;
    /*
    *1:文件夹
    */
    private Integer fileType;
    /*
    *
    */
    private Integer isDeleted;
    /*
    *
    */
    private Date createdAt;
}