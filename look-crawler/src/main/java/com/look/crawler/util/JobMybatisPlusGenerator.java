package com.look.crawler.util;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.look.common.config.mybatisConfig.GeneratorCodeConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource(value = "classpath:config/mybatis-plus-source.properties")
public class JobMybatisPlusGenerator {
    @Value("${job.url}")
    private String jobUrl;

    @Value("${job.username}")
    private String jobUserName;

    @Value("${job.password}")
    private String jobPassword;

    @Value("${job.driverName}")
    private String jobDriverName;

    @Value("${crawler.moduleName}")
    private String moduleName;

    @Value("${crawler.parent}")
    private String parent;

    @Value("${crawler.entity}")
    private String entity;

    @Value("${crawler.mapper}")
    private String mapper;

    @Value("${crawler.job.xml}")
    private String jobXml;

    @Value("${crawler.service}")
    private String service;

    @Value("${crawler.serviceImpl}")
    private String serviceImpl;
    
    public void JobGenerator() {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl(jobUrl);
        dataSourceConfig.setDriverName(jobDriverName);
        dataSourceConfig.setUsername(jobUserName);
        dataSourceConfig.setPassword(jobPassword);

        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setModuleName(moduleName);
        packageConfig.setParent(parent);
        packageConfig.setEntity(entity);
        packageConfig.setMapper(mapper);
        packageConfig.setXml(jobXml);
        packageConfig.setService(service);
        packageConfig.setServiceImpl(serviceImpl);

        String[] tableName = new String[]{"jobs"};
        GeneratorCodeConfig.mybatisPlusGenerator(dataSourceConfig,packageConfig,tableName);

    }
}
