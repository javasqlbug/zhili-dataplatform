package com.niezhili.dataplatform.dataservice.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * @author niezhili
 * @date 2021-05-23
 */
@SpringBootApplication
@ServletComponentScan
@ComponentScan(value = "com.niezhili.dataplatform.dataservice",
        excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "org.apache.dolphinscheduler.server.*"))
public class ZhiliDataServiceAdminApplicationServer extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ZhiliDataServiceAdminApplicationServer.class, args);
    }

}
