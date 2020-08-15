package com.weds.edpf.core;

import com.weds.core.annotation.MyBatisDao;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages = {"com.weds.web", "com.weds.edpf.core", "com.weds.rpt"})
@MapperScan(basePackages = {"com.weds.**.mapper"}, annotationClass = MyBatisDao.class)
public class EdpfApplication {
    public static void main(String[] args) {
        SpringApplication.run(EdpfApplication.class, args);
    }
}
