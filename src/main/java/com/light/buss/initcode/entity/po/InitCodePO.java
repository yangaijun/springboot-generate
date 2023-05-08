package com.light.buss.initcode.entity.po;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Data
@TableName(value = "init_code")
public class InitCodePO {
    /*
    *
    */
    @TableId
    private Integer initCodeId;
    /*
    *
    */
    private Integer pageId;
    /*
    *代码类型
    *var: 变量
    *fn: 函数
    *effect: 副作用
    */
    private String initCodeType;
    /*
    *变量名
    */
    private String initCodeName;
    /*
    *影响
    */
    private String initCodeEffect;
    /*
    *变量值
    */
    private String initCodeValue;
    /*
    *
    */
    private Date createdAt;
    /*
    *
    */
    private Integer isDeleted;
}