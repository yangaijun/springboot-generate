package com.light.common.generate;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class TableInfo {

    private String tableName;

    private String tableComment;

    private List<ColumnInfo> columns;

    private Map<String, String> status;

    private Map<String, String> type;
}
