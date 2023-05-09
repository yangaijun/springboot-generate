package com.light.common.generate;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class TableInfo {

    private String tableName;

    private String tableComment;

    private List<ColumnInfo> columns;
    //字段枚举
    private Map<String, String> type;
}
