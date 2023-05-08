package com.light.buss.component.entity.vo;

import lombok.Data;
import com.light.common.pojo.PageParam;
import java.util.Date;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Data
public class ComponentVO extends PageParam {
    /*
    *
    */
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