package com.light.buss.plugsame.entity.po;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Data
@TableName(value = "plug_same")
public class PlugSamePO {
    /*
    *
    */
    @TableId
    private Integer plugSameId;
    /*
    *最后的组件id
    */
    private Integer lastPlugId;
    /*
    *
    */
    private Integer isDeleted;
    /*
    *
    */
    private Date createdAt;
}