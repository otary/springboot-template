package cn.chenzw.springboot.one.service.impl;

import cn.chenzw.springboot.one.domain.entity.TypesEntity;
import cn.chenzw.springboot.one.repository.mybatis.TypesMapper;
import cn.chenzw.springboot.one.service.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenzw
 */
@Service
public class TypesServiceImpl implements TypesService {

    @Autowired
    TypesMapper typesMapper;

    @Override
    public List<TypesEntity> listAll() {
        return typesMapper.selectAll();
    }
}
