package com.light.buss.nametranslator.entity.po;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Data
@TableName(value = "name_translator")
public class NameTranslatorPO {
    /*
    *
    */
    @TableId
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