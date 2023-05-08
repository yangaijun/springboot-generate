package com.light.buss.componentpropdoc.entity.vo;

import lombok.Data;
import com.light.common.pojo.PageParam;
import java.util.Date;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Data
public class ComponentPropDocVO extends PageParam {
    /*
    *
    */
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