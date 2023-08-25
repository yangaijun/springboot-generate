package com.light.business.grade.entity.po;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableLogic;

/*
 * @Description: 
 * @date: 2023-08-25
 */
@Data
@TableName(value = "grade")
public class GradePO {
    /*
    *
    */
    @TableId
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
    @TableLogic
    private Integer deleted;
}