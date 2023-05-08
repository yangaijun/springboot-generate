package com.light.common.generate.controller;

import com.light.common.generate.Util;
import com.light.common.generate.service.GenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/generate")
public class GenerateController {
    @Value("${spring.datasource.url}")
    private String databaseUrl;
    @Autowired
    private GenerateService generateService;

    @RequestMapping(value = "/index")
    public String index() throws IOException {
        String schema = databaseUrl.substring(databaseUrl.lastIndexOf("/") + 1, databaseUrl.indexOf("?"));
        List<String> tableNames = generateService.getTableNames(schema);
        generateService.generation(Util.addFileSeparator(System.getProperty("user.dir"), "src", "main","java","com","light", "buss"), schema, tableNames);
        return "ok";
    }
}
