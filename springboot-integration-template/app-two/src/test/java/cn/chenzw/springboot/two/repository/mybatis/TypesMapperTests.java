package cn.chenzw.springboot.two.repository.mybatis;

import cn.chenzw.springboot.two.WebApp;
import cn.chenzw.springboot.two.domain.entity.TypesEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
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
