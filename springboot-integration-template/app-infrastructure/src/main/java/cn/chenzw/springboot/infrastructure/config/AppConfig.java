package cn.chenzw.springboot.infrastructure.config;

import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean() {
        return new DozerBeanMapperFactoryBean();
    }

}
