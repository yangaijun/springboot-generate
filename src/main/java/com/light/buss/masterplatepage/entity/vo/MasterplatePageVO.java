package com.light.buss.masterplatepage.entity.vo;

import lombok.Data;
import com.light.common.pojo.PageParam;
import java.util.Date;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Data
public class MasterplatePageVO extends PageParam {
    /*
    *
    */
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