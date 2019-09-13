package cn.chenzw.springboot.infrastructure.repository.mybatis;

import cn.chenzw.springboot.infrastructure.domain.entity.SysLogEntity;
import cn.chenzw.springboot.infrastructure.support.mybatis.TkMyBatisRepository;
import tk.mybatis.mapper.common.BaseMapper;

@TkMyBatisRepository
public interface SysLogMapper extends BaseMapper<SysLogEntity> {
    
}
