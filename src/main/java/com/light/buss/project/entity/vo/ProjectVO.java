package com.light.buss.project.entity.vo;

import lombok.Data;
import com.light.common.pojo.PageParam;
import java.util.Date;

/*
 * @Description: 
 * @date: 2023-05-08
 */
@Data
public class ProjectVO extends PageParam {
    /*
    *
    */
    private Integer projectId;
    /*
    *
    */
    private Integer masterplateProjectId;
    /*
    *母版ID,可以为空,记录系统是否很用一键生成
    */
    private Integer masterplatePageId;
    /*
    *
    */
    private Integer userId;
    /*
    *
    */
    private String projectName;
    /*
    *项目角色
    */
    private String projectRoles;
    /*
    *private:私有的
    *public:公共的
    */
    private String projectType;
    /*
    *
    */
    private String projectDes;
    /*
    *
    */
    private String colFilter;
    /*
    *
    */
    private String databaseUrl;
    /*
    *
    */
    private String databaseUsername;
    /*
    *
    */
    private String databasePassword;
    /*
    *
    */
    private Date createdAt;
}