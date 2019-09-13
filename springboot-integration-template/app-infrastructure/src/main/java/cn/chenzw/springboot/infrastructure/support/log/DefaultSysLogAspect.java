package cn.chenzw.springboot.infrastructure.support.log;

import cn.chenzw.springboot.infrastructure.domain.entity.SysLogEntity;
import cn.chenzw.springboot.infrastructure.repository.mybatis.SysLogMapper;
import cn.chenzw.toolkit.spring.aop.JoinPointWrapper;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 默认的日志切面类
 */
@Component
@Aspect
public class DefaultSysLogAspect extends AbstractSysLogAspect {

    @Autowired
    SysLogMapper sysLogMapper;

    @Override
    protected void before(JoinPointWrapper joinPointWrapper, SysLogEntity sysLogEntity) {
        sysLogMapper.insertSelective(sysLogEntity);
    }

    @Override
    protected void after(JoinPointWrapper joinPointWrapper, SysLogEntity sysLogEntity) {

    }

    @Override
    protected void afterReturning(JoinPointWrapper joinPointWrapper, Object ret, SysLogEntity sysLogEntity) {
        sysLogMapper.updateByPrimaryKeySelective(sysLogEntity);
    }

    @Override
    protected void afterThrowing(JoinPointWrapper joinPointWrapper, Throwable ex, SysLogEntity sysLogEntity) {
        sysLogMapper.updateByPrimaryKeySelective(sysLogEntity);
    }
}
