package com.light.common.generate.controller;

import com.light.common.generate.Util;
import com.light.common.generate.service.GenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/generate")
public class GenerateController {
    @Value("${spring.datasource.url}")
    private String databaseUrl;
    @Autowired
    private GenerateService generateService;

    private static String comPath = "com.light.business";

    private static String[] filePath = new String[]{ System.getProperty("user.dir"), "src", "main", "java", "com", "light", "business" };

    @RequestMapping(value = "/index")
    public ModelAndView index(String[] table) throws IOException {
        String schema = databaseUrl.substring(databaseUrl.lastIndexOf("/") + 1, databaseUrl.indexOf("?"));

        if (table != null) {
            generateService.generation(Util.addFileSeparator(filePath), comPath, schema, Arrays.asList(table));
        }

        ModelAndView view = new ModelAndView();
        view.setViewName("/generate/index.btl");
        view.addObject("tableNames", generateService.getTableNames(schema));
        return view;
    }
}
