package com.weds.edhy;

import com.weds.core.annotation.MyBatisDao;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = {"com.weds.web", "com.weds.edpf", "com.weds.edhy", "com.weds.rpt"})
@MapperScan(basePackages = {"com.weds.**.mapper"}, annotationClass = MyBatisDao.class)
public class EdhyApplication {

    public static void main(String[] args) {
        SpringApplication.run(EdhyApplication.class, args);
    }

}
