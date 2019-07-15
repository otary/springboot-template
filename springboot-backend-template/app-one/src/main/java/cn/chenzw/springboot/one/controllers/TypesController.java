package cn.chenzw.springboot.one.controllers;

import cn.chenzw.springboot.one.domain.entity.TypesEntity;
import cn.chenzw.springboot.one.service.TypesService;
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

        try{

        }catch (Exception e){
            e.printStackTrace();
        }

        return typesService.listAll();
    }

}
