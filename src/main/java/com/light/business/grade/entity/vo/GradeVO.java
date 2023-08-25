package com.light.business.grade.entity.vo;

import lombok.Data;
import com.light.common.pojo.PageParam;
import java.util.Date;

/*
 * @Description: 
 * @date: 2023-08-25
 */
@Data
public class GradeVO extends PageParam {
    /*
    *
    */
    private Integer gradeId;
    /*
    *
    */
    private Integer studentId;
    /*
    *考试名称
    */
    private String gradeName;
    /*
    *语文成绩
    */
    private String gradeChinese;
    /*
    *数学成绩
    */
    private String gradeMath;
    /*
    *英文成绩
    */
    private String gradeEnglish;
    /*
    *
    */
    private Date createdAt;
    /*
    *
    */
    private Integer deleted;
}