package cn.chenzw.springboot.infrastructure.config;

import cn.chenzw.springboot.infrastructure.support.mybatis.TkMyBatisRepository;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

@Configuration
@MapperScan(basePackages = {"cn.chenzw.springboot"}, annotationClass = TkMyBatisRepository.class)
public class MybatisConfig {


}
