package cn.chenzw.springboot.two.controllers;

import cn.chenzw.springboot.two.domain.entity.TypesEntity;
import cn.chenzw.springboot.two.service.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/types")
public class TypesController {

    @Autowired
    TypesService typesService;


    @GetMapping("/list")
    public List<TypesEntity> listAll() {
        return typesService.listAll();
    }

}
