package cn.chenzw.springboot.infrastructure.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"cn.chenzw.springboot"})
public class MybatisConfig {




}
