package com.light.business.student.entity.vo;

import lombok.Data;
import com.light.common.pojo.PageParam;
import java.util.Date;

/*
 * @Description: 
 * @date: 2023-08-25
 */
@Data
public class StudentVO extends PageParam {
    /*
    *主键
    */
    private Integer studentId;
    /*
    *学生姓名
    */
    private String studentName;
    /*
    *学号
    */
    private String studentNo;
    /*
    *入学日期
    */
    private Date studentInTime;
    /*
    *创建日期
    */
    private Date createdAt;
    /*
    *逻辑删除
    */
    private Integer deleted;
}