package com.light.common.generate.service;

import com.light.common.generate.ColumnInfo;
import com.light.common.generate.Config;
import com.light.common.generate.TableInfo;
import com.light.common.generate.Util;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GenerateService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<String> getTableNames(String tableSchema) {
        String sql = "SELECT table_name as tableName FROM INFORMATION_SCHEMA.TABLES\n" +
                "WHERE table_schema = '" + tableSchema + "'";
        return jdbcTemplate.query(sql, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getString(1);
            }
        });
    }
    private void doPo(GroupTemplate gt, TableInfo table, String comPath, String filePath) {
        Template t = gt.getTemplate("po.template");
        String entityName = Util.toEntityTableName(table.getTableName());
        String tableFileName = Util.removeUnderlineAndLowerCase(table.getTableName());

        t.binding("entityName", Util.toEntityTableName(table.getTableName()));
        t.binding("poSuffix", Config.poSuffix);
        t.binding("package",  Util.addComSeparator(comPath, tableFileName, Config.entityFolderName, Config.poFolderName));
        t.binding("logicName", Config.logicName);
        t.binding("_root", table);

        Util.writeFile(t, Util.addFileSeparator(filePath, tableFileName, Config.entityFolderName, Config.poFolderName, entityName + Config.poSuffix + ".java"), Config.poOnUpdateOverWrite);
    }

    private void doVo(GroupTemplate gt, TableInfo table, String comPath, String filePath) {
        Template t = gt.getTemplate("vo.template");
        String entityName = Util.toEntityTableName(table.getTableName());
        String tableFileName = Util.removeUnderlineAndLowerCase(table.getTableName());

        t.binding("entityName", Util.toEntityTableName(table.getTableName()));
        t.binding("voSuffix", Config.voSuffix);
        t.binding("package",  Util.addComSeparator(comPath, tableFileName, Config.entityFolderName, Config.voFolderName));
        t.binding("_root", table);

        Util.writeFile(t, Util.addFileSeparator(filePath, tableFileName, Config.entityFolderName, Config.voFolderName, entityName + Config.voSuffix + ".java"), Config.voOnUpdateOverWrite);
    }
    private void doMapperXml(GroupTemplate gt, TableInfo table, String comPath, String filePath) {
        Template t = gt.getTemplate("mapper-xml.template");
        String tableFileName = Util.removeUnderlineAndLowerCase(table.getTableName());

        String entityName = Util.toEntityTableName(table.getTableName());
        t.binding("namespace", Util.addComSeparator(comPath, tableFileName, Config.mapperFolderName, entityName + Config.mapperSuffix));

        Util.writeFile(t, Util.addFileSeparator(filePath, tableFileName, Config.mapperFolderName, entityName + Config.mapperSuffix + ".xml"), Config.mapperXmlOnUpdateOverWrite);
    }
    private void doMapperJava(GroupTemplate gt, TableInfo table, String comPath, String filePath) {
        Template t = gt.getTemplate("mapper-java.template");
        String entityName = Util.toEntityTableName(table.getTableName());
        String tableFileName = Util.removeUnderlineAndLowerCase(table.getTableName());

        t.binding("poSuffix", Config.poSuffix);
        t.binding("entityName", entityName);
        t.binding("package", Util.addComSeparator(comPath, tableFileName, Config.mapperFolderName));
        t.binding("impPo", Util.addComSeparator(comPath, tableFileName, Config.entityFolderName, Config.poFolderName, entityName + Config.poSuffix));
        t.binding("_root", table);

        Util.writeFile(t, Util.addFileSeparator(filePath, tableFileName, Config.mapperFolderName, entityName + Config.mapperSuffix + ".java"), Config.mapperJavaOnUpdateOverWrite);
    }

    private void doService(GroupTemplate gt, TableInfo table, String comPath, String filePath) {
        Template t = gt.getTemplate("service.template");
        String entityName = Util.toEntityTableName(table.getTableName());
        String tableFileName = Util.removeUnderlineAndLowerCase(table.getTableName());

        t.binding("poSuffix", Config.poSuffix);
        t.binding("entityName", entityName);
        t.binding("varName", Util.toEntityName(table.getTableName()));
        t.binding("package", Util.addComSeparator(comPath, tableFileName, Config.serviceFolderName));
        t.binding("impPo", Util.addComSeparator(comPath, tableFileName, Config.entityFolderName, Config.poFolderName, entityName + Config.poSuffix));
        t.binding("impMapper", Util.addComSeparator(comPath, tableFileName, Config.mapperFolderName, entityName + "Mapper"));
        t.binding("_root", table);

        Util.writeFile(t, Util.addFileSeparator(filePath, tableFileName, Config.serviceFolderName, entityName + "Service.java"), Config.serviceOnUpdateOverWrite);
    }

    private void doController(GroupTemplate gt, TableInfo table, String comPath, String filePath) {
        Template t = gt.getTemplate("controller.template");
        String entityName = Util.toEntityTableName(table.getTableName());
        String tableFileName = Util.removeUnderlineAndLowerCase(table.getTableName());

        t.binding("poSuffix", Config.poSuffix);
        t.binding("voSuffix", Config.voSuffix);
        t.binding("entityName", entityName);
        t.binding("varName", Util.toEntityName(table.getTableName()));
        t.binding("package", Util.addComSeparator(comPath, tableFileName, Config.controllerFolderName));
        t.binding("impPo", Util.addComSeparator(comPath, tableFileName, Config.entityFolderName, Config.poFolderName, entityName + Config.poSuffix));
        t.binding("impVo", Util.addComSeparator(comPath, tableFileName, Config.entityFolderName, Config.voFolderName, entityName + Config.voSuffix));
        t.binding("impService", Util.addComSeparator(comPath, tableFileName, Config.serviceFolderName, entityName + "Service"));
        t.binding("_root", table);

        Util.writeFile(t, Util.addFileSeparator(filePath, tableFileName, Config.controllerFolderName, entityName + "Controller.java") , Config.controllerOnUpdateOverWrite);
    }

    public List<TableInfo> getTableInfoList(String schema, List<String> tableNames) {
        List<TableInfo> tableInfoList = new ArrayList<>();
        for (String tableName: tableNames) {
            String sql = " select DISTINCT COLUMN_NAME as columnName, ORDINAL_POSITION as ordinalPosition, DATA_TYPE as dataType, COLUMN_KEY as columnKey, COLUMN_COMMENT as columnComment, TABLE_COMMENT AS tableComment " +
                    " from information_schema.COLUMNS c" +
                    " left join INFORMATION_SCHEMA.TABLES t" +
                    " on c.TABLE_NAME = t.TABLE_NAME" +
                    " and c.TABLE_SCHEMA = t.TABLE_SCHEMA" +
                    " where c.TABLE_NAME = '" + tableName + "' and c.table_schema = '" + schema + "'";

            List<ColumnInfo> columns = jdbcTemplate.query(sql, new RowMapper<ColumnInfo>() {
                public ColumnInfo mapRow(ResultSet resultSet, int i) throws SQLException {
                    ColumnInfo columnInfo = new ColumnInfo();
                    columnInfo.setColumnName(resultSet.getString(1));
                    columnInfo.setEntityColumnName(Util.toEntityName(resultSet.getString(1)));
                    columnInfo.setEntityColumnMethodName(Util.toEntityTableName(resultSet.getString(1)));
                    columnInfo.setOrdinalPosition(resultSet.getInt(2));
                    columnInfo.setDataType(resultSet.getString(3));
                    columnInfo.setFieldType(Util.dbTypeToJavaType(resultSet.getString(3)));
                    columnInfo.setColumnKey(resultSet.getString(4));
                    columnInfo.setColumnComment(resultSet.getString(5));
                    return columnInfo;
                }
            });
            TableInfo tableInfo = new TableInfo();
            //从注释中解出枚举类型
//			Map<String, String> type = new HashMap<>();
//			for (ColumnInfo column: columns) {
//				if (column.getColumnComment() != null) {
//					if (column.getColumnComment().indexOf(Config.typeStartString) >= 0) {
//						int end = column.getColumnComment().indexOf(Config.typeStartString) + Config.typeStartString.length();
//						String columnType = column.getColumnComment().substring(end).replaceAll(" ", "");
//						type.put(column.getColumnName(), columnType);
//					}
//				}
//			}
//            if (!type.isEmpty()) {
//                tableInfo.setType(type);
//            }

            tableInfo.setTableName(tableName);
            tableInfo.setColumns(columns);

            tableInfoList.add(tableInfo);
        }
        return tableInfoList;
    }

    public void generation(String filePath, String comPath, String schema, List<String> tableNames) throws IOException {
        ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader("beetl-back-end");
        Configuration cfg = Configuration.defaultConfiguration();
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);

        List<TableInfo> tableInfoList = getTableInfoList(schema, tableNames);

        System.out.println("generate start");
        for (TableInfo tableInfo: tableInfoList) {
            doPo(gt, tableInfo, comPath, filePath);
            doVo(gt, tableInfo, comPath, filePath);

            doMapperJava(gt, tableInfo, comPath, filePath);
            doMapperXml(gt, tableInfo, comPath, filePath);

            doService(gt, tableInfo, comPath, filePath);
            doController(gt, tableInfo, comPath, filePath);
        }
        System.out.println("generate over");
    }
}
