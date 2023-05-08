package com.light.buss.file.entity.vo;

import lombok.Data;
import com.light.common.pojo.PageParam;
import java.util.Date;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Data
public class FileVO extends PageParam {
    /*
    *
    */
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