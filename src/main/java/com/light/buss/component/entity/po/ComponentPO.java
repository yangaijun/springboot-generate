package com.light.buss.component.entity.po;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Data
@TableName(value = "component")
public class ComponentPO {
    /*
    *
    */
    @TableId
    private Integer componentId;
    /*
    *
    */
    private Integer projectId;
    /*
    *
    */
    private Integer componentFromId;
    /*
    *
    */
    private String componentDes;
    /*
    *
    */
    private String componentName;
    /*
    *
    */
    private String componentDataList;
    /*
    *
    */
    private Date createAt;
    /*
    *
    */
    private Integer isDeleted;
}