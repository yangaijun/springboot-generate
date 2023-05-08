package com.light.buss.pluguse.entity.po;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Data
@TableName(value = "plug_use")
public class PlugUsePO {
    /*
    *
    */
    @TableId
    private Integer plugUseId;
    /*
    *
    */
    private Integer projectId;
    /*
    *
    */
    private Integer userId;
    /*
    *
    */
    private Integer plugId;
    /*
    *
    */
    private String plugUseName;
    /*
    *
    */
    private String plugUseType;
    /*
    *
    */
    private Integer plugUseVersion;
    /*
    *
    */
    private Date createdAt;
    /*
    *
    */
    private Integer isDeleted;
}