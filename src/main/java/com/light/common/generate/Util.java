package com.light.common.generate;

import org.beetl.core.Template;

import java.io.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Util {
    private static Pattern linePattern = Pattern.compile("_(\\w)");

    public static String toTableColumn(String attribute) {
        return attribute.replaceAll("[A-Z]", "_$0").toLowerCase();
    }
    public static String toEntityName(String tableName) {
        Matcher matcher = linePattern.matcher(tableName);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public static String toEntityTableName(String tableName) {
        String name = toEntityName(tableName);

        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }

    public static String dbTypeToJavaType(String type) {
        type = type.toUpperCase();
        switch(type){
            case "NUMBER":
            case "DECIMAL":
                return "BigDecimal";

            case "TINYINT":
            case "SMALLINT":
            case "MEDIUMINT":
            case "INT":
            case "BIT":
                return "Integer";

            case "BIGINT":
                return "Long";

            case "DATETIME":
            case "TIMESTAMP":
            case "DATE":
                return "Date";

            case "VARCHAR":
            case "CHAR":
            default:
                return "String";
        }
    }

    public static String addFileSeparator(String ...paths) {
        return Arrays.asList(paths).stream().collect(Collectors.joining(File.separator));
    }

    public static String addComSeparator(String ...paths) {
        return Arrays.asList(paths).stream().collect(Collectors.joining("."));
    }

    public static String removeUnderlineAndLowerCase(String string) {
        return string.replaceAll("_", "").toLowerCase();
    }

    public static void writeFile(Template t, String filePath, boolean override) {
        File file = new File(filePath);
        if (file.isDirectory()) {
            return;
        }

        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        try {
            if(!file.exists()) {
                file.createNewFile();
            } else if (file.exists() && !override) {
                return;
            }

            OutputStream os = new FileOutputStream(file);
            t.renderTo(os);

            System.out.println(file.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
