package cn.chenzw.springboot.infrastructure.support.log;


import cn.chenzw.springboot.infrastructure.domain.entity.SysLogEntity;
import cn.chenzw.springboot.infrastructure.repository.mybatis.SysLogMapper;
import cn.chenzw.toolkit.spring.aop.JoinPointWrapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Calendar;

/**
 * 日志切面抽象类
 *
 * @author chenzw
 */
public abstract class AbstractSysLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(AbstractSysLogAspect.class);
    private static final String POINT_CUT = "sysLog()";

    private ThreadLocal<JoinPointWrapper> joinPointWrapperTL = new ThreadLocal<>();
    private ThreadLocal<SysLogEntity> sysLogTL = new ThreadLocal<>();


    @Pointcut("@annotation(SysLog)")
    public void sysLog() {
    }


    /**
     * @param joinPointWrapper
     * @param sysLogEntity
     */
    protected abstract void before(JoinPointWrapper joinPointWrapper, SysLogEntity sysLogEntity);


    /**
     * @param joinPointWrapper
     * @param sysLogEntity
     */
    protected abstract void after(JoinPointWrapper joinPointWrapper, SysLogEntity sysLogEntity);


    /**
     * return时的处理类
     *
     * @param joinPointWrapper
     * @param ret              返回值
     * @param sysLogEntity
     */
    protected abstract void afterReturning(JoinPointWrapper joinPointWrapper, Object ret, SysLogEntity sysLogEntity);


    /**
     * 抛出异常时的处理类
     *
     * @param joinPointWrapper
     * @param ex               抛出的异常
     * @param sysLogEntity
     */
    protected abstract void afterThrowing(JoinPointWrapper joinPointWrapper, Throwable ex, SysLogEntity sysLogEntity);


    @Before(POINT_CUT)
    public void before(JoinPoint joinPoint) {

        JoinPointWrapper joinPointWrapper = new JoinPointWrapper(joinPoint);
        joinPointWrapperTL.set(joinPointWrapper);

        SysLog sysLogAnn = joinPointWrapper.getAnnotation(SysLog.class);

        SysLogEntity sysLogEntity = new SysLogEntity();
        sysLogTL.set(sysLogEntity);

        sysLogEntity.setModuleName(StringUtils.defaultIfBlank(sysLogAnn.moduleName(), joinPointWrapper.getArtifactId()));
        sysLogEntity.setAppName(StringUtils.defaultIfBlank(sysLogAnn.appName(), sysLogEntity.getModuleName()));
        sysLogEntity.setHttpMethod(joinPointWrapper.getHttpMethod());
        sysLogEntity.setRequestURI(joinPointWrapper.getURI());
        sysLogEntity.setRequestQueryString(joinPointWrapper.getQueryString());
        sysLogEntity.setClientIp(joinPointWrapper.getClientIp());
        sysLogEntity.setStartTime(Calendar.getInstance().getTime());

        try {
            sysLogEntity.setRequestBody(joinPointWrapper.getBodyString());
        } catch (IOException ex) {
            sysLogEntity.setExMsg(ex.getMessage());
        }

        before(joinPointWrapper, sysLogEntity);
    }


    @After(POINT_CUT)
    public void after(JoinPoint joinPoint) {
        after(joinPointWrapperTL.get(), sysLogTL.get());
    }

    @AfterReturning(pointcut = POINT_CUT, returning = "ret")
    public void afterReturning(JoinPoint joinPoint, Object ret) {
        SysLogEntity sysLogEntity = sysLogTL.get();
        sysLogEntity.setSuccess(true);
        sysLogEntity.setFinishTime(Calendar.getInstance().getTime());
        sysLogEntity.setCost(sysLogEntity.getFinishTime().getTime() - sysLogEntity.getStartTime().getTime());
        sysLogEntity.setReturning(String.valueOf(ret));

        afterReturning(joinPointWrapperTL.get(), ret, sysLogEntity);
    }

    @AfterThrowing(pointcut = POINT_CUT, throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
        SysLogEntity sysLogEntity = sysLogTL.get();
        sysLogEntity.setSuccess(false);
        sysLogEntity.setFinishTime(Calendar.getInstance().getTime());
        sysLogEntity.setCost(sysLogEntity.getFinishTime().getTime() - sysLogEntity.getStartTime().getTime());
        sysLogEntity.setExMsg(ExceptionUtils.getStackTrace(ex));

        afterThrowing(joinPointWrapperTL.get(), ex, sysLogEntity);
    }

}
