package com.light.buss.nametranslator.entity.vo;

import lombok.Data;
import com.light.common.pojo.PageParam;
import java.util.Date;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Data
public class NameTranslatorVO extends PageParam {
    /*
    *
    */
    private Integer nameTranslatorId;
    /*
    *
    */
    private String nameTranslatorForm;
    /*
    *
    */
    private String nameTranslatorto;
    /*
    *
    */
    private Date createdAt;
    /*
    *
    */
    private Integer isDeleted;
}