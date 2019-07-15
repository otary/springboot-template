package cn.chenzw.springboot.one.service;

import cn.chenzw.springboot.infrastructure.domain.entity.TypesEntity;

import java.util.List;

public interface TypesService {

    List<TypesEntity> listAll();
}
