package com.light.common.generate;

import lombok.Data;

@Data
public class ColumnInfo {

    private String columnName;

    private String entityColumnName;

    private String entityColumnMethodName;

    private String fieldType;
    /**
     * 位置
     */
    private Integer ordinalPosition;
    /**
     * 数据类型
     */
    private String dataType;
    /**
     * 列主键描述，PRI为主键
     */
    private String columnKey;
    /**
     * 列描述
     */
    private String columnComment;
}
