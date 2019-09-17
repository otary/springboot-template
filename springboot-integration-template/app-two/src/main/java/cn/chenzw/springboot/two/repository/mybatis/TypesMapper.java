package cn.chenzw.springboot.two.repository.mybatis;

import cn.chenzw.springboot.infrastructure.support.mybatis.TkMyBatisRepository;
import cn.chenzw.springboot.two.domain.entity.TypesEntity;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

@Repository
@TkMyBatisRepository
public interface TypesMapper extends BaseMapper<TypesEntity> {


}
