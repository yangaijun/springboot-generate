package com.light.buss.masterplatepage.entity.po;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Data
@TableName(value = "masterplate_page")
public class MasterplatePagePO {
    /*
    *
    */
    @TableId
    private Integer masterplatePageId;
    /*
    *
    */
    private Integer userId;
    /*
    *模版名称
    */
    private String masterplatePageName;
    /*
    *
    */
    private Integer masterplatePageMaster;
    /*
    *public:公共的
    *private:私有的
    *sys:系统模版
    */
    private String masterplatePageType;
    /*
    *描述
    */
    private String masterplatePageDes;
    /*
    *
    */
    private Integer isDeleted;
    /*
    *
    */
    private Date createdAt;
    /*
    *
    */
    private String masterplatePageTmp;
}