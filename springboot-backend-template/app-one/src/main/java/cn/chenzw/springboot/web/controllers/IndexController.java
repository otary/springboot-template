package cn.chenzw.springboot.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class IndexController {

    @GetMapping("/index")
    public String index(){
        System.out.println("----------------");
        return "/index";
    }
}
