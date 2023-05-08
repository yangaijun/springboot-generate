package com.light.buss.componentpropdoc.entity.po;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Data
@TableName(value = "component_prop_doc")
public class ComponentPropDocPO {
    /*
    *
    */
    @TableId
    private Integer componentPropDocId;
    /*
    *
    */
    private Integer plugId;
    /*
    *对应的prop
    */
    private String componentPropDocProp;
    /*
    *如click,多个 cilck 通过sort 组件一组文档
    */
    private String componentPropDocName;
    /*
    *注释
    */
    private String componentPropDocRem;
    /*
    *代码
    */
    private String componentPropDocCode;
    /*
    *
    */
    private Integer componentPropDocSort;
    /*
    *
    */
    private Date createdAt;
    /*
    *
    */
    private Integer isDeleted;
}