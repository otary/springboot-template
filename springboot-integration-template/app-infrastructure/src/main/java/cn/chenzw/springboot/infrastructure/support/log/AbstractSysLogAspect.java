package cn.chenzw.springboot.infrastructure.support.log;


import cn.chenzw.springboot.infrastructure.domain.entity.SysLog;
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
public class AbstractSysLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(AbstractSysLogAspect.class);
    private static final String POINT_CUT = "sysLog()";

    private ThreadLocal<JoinPointWrapper> joinPointWrapperTL = new ThreadLocal<>();
    private ThreadLocal<SysLog> sysLogTL = new ThreadLocal<>();

    @Autowired
    SysLogMapper sysLogMapper;

    @Pointcut("@annotation(com.ffcs.itm.cloud.infrastructure.support.log.SysLog)")
    public void sysLog() {

    }

    @Before(POINT_CUT)
    public void before(JoinPoint joinPoint) {
        JoinPointWrapper joinPointWrapper = new JoinPointWrapper(joinPoint);
        joinPointWrapperTL.set(joinPointWrapper);

        SysLog sysLogAnn = joinPointWrapper
                .getAnnotation(SysLog.class);

        SysLog sysLog = new SysLog();
        sysLogTL.set(sysLog);

        sysLog.setModuleName(StringUtils.defaultIfBlank(sysLogAnn.moduleName(), joinPointWrapper.getArtifactId()));
        sysLog.setAppName(StringUtils.defaultIfBlank(sysLogAnn.appName(), sysLog.getModuleName()));
        sysLog.setHttpMethod(joinPointWrapper.getHttpMethod());
        sysLog.setRequestURI(joinPointWrapper.getURI());
        try {
            sysLog.setRequestBody(joinPointWrapper.getBodyString());
        } catch (IOException ex) {
            sysLog.setExMsg(ex.getMessage());
        }
        sysLog.setRequestQueryString(joinPointWrapper.getQueryString());
        sysLog.setClientId(joinPointWrapper.getClientIp());
        sysLog.setStartTime(Calendar.getInstance().getTime());
        for (JoinPointWrapper.ParamMeta paramMeta : joinPointWrapper.getMethodArgs()) {
            if (BaseParam.class.isAssignableFrom(paramMeta.getType())) {
                BaseParam baseParam = (BaseParam) paramMeta.getValue();
                if (baseParam.getOperator() != null) {
                    sysLog.setOperator(baseParam.getOperator().getOperatorId());
                    sysLog.setOperatorName(baseParam.getOperator().getOperatorName());
                }
            }
        }
        sysLogMapper.insertSelective(sysLog);
    }

    @After(POINT_CUT)
    public void after(JoinPoint joinPoint) {

    }

    @AfterReturning(pointcut = POINT_CUT, returning = "ret")
    public void afterReturning(JoinPoint joinPoint, Object ret) {
        SysLog sysLog = sysLogTL.get();
        sysLog.setSuccess(true);
        sysLog.setFinishTime(Calendar.getInstance().getTime());
        sysLog.setCost(sysLog.getFinishTime().getTime() - sysLog.getStartTime().getTime());
        sysLog.setReturning(String.valueOf(ret));

        sysLogMapper.updateByPrimaryKeySelective(sysLog);
    }

    @AfterThrowing(pointcut = POINT_CUT, throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
        SysLog sysLog = sysLogTL.get();
        sysLog.setSuccess(false);
        sysLog.setFinishTime(Calendar.getInstance().getTime());
        sysLog.setCost(sysLog.getFinishTime().getTime() - sysLog.getStartTime().getTime());
        sysLog.setExMsg(ExceptionUtils.getStackTrace(ex));

        sysLogMapper.updateByPrimaryKeySelective(sysLog);

    }

}
