package cn.chenzw.springboot.one.repository.mybatis;

import cn.chenzw.springboot.infrastructure.domain.entity.TypesEntity;
import cn.chenzw.springboot.one.WebApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WebApp.class)
@WebAppConfiguration
public class TypesMapperTests {

    @Autowired
    TypesMapper typesMapper;

    @Test
    public void testListAll(){
        List<TypesEntity> typesEntities = typesMapper.selectAll();

        System.out.println(typesEntities);
    }

}
