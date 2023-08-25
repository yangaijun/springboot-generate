package com.light.business.student.entity.po;

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
@TableName(value = "student")
public class StudentPO {
    /*
    *主键
    */
    @TableId
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
    @TableLogic
    private Integer deleted;
}