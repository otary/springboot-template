package cn.chenzw.springboot.infrastructure.config;

import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.TimeZone;

@Configuration
public class AppConfig {

    @Bean
    public DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean() {
        return new DozerBeanMapperFactoryBean();
    }


    /**
     * 时区配置
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonObjectMapperCustomization()  {
        return jacksonObjectMapperBuilder -> jacksonObjectMapperBuilder.timeZone(TimeZone.getDefault());
    }
}
