package com.light.buss.masterplateproject.entity.po;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Data
@TableName(value = "masterplate_project")
public class MasterplateProjectPO {
    /*
    *
    */
    @TableId
    private Integer masterplateProjectId;
    /*
    *
    */
    private Integer userId;
    /*
    *
    */
    private String masterplateProjectName;
    /*
    *路径//http://localhost:3000
    */
    private String masterplateProjectBaseUrl;
    /*
    *
    */
    private String masterplateProjectTokenName;
    /*
    *
    */
    private String masterplateProjectContentType;
    /*
    *语法//保存字段
    *hook
    *class
    */
    private String masterplateProjectGrammar;
    /*
    *全局数据
    */
    private String masterplateProjectData;
    /*
    *组件配置
    */
    private String masterplateProjectFreedomenConfig;
    /*
    *
    */
    private String masterplateProjectStyle;
    /*
    *描述
    */
    private String masterplateProjectDes;
    /*
    *public: 公共的
    *private: 私有的
    *sys:系统模版
    */
    private String masterplateProjectType;
    /*
    *
    */
    private Integer isDeleted;
    /*
    *
    */
    private Date createdAt;
}