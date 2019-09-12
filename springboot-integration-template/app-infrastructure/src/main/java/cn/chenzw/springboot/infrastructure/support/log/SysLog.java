package cn.chenzw.springboot.infrastructure.support.log;

import java.lang.annotation.*;

/**
 * 日志切面注解
 *
 * @author chenzw
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface SysLog {

    /**
     * 应用名称（默认：同moduleName）
     * @return
     */
    String appName() default "";

    /**
     * 模块名称（默认：artifactId）
     * @return
     */
    String moduleName() default "";



}
