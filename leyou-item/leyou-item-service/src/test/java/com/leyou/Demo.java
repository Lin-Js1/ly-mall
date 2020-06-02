package com.leyou;

import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import org.junit.Test;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Demo {

    @Autowired
    BrandMapper brandMapper;

    @Test
    public void test(){
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("name","TCL").andEqualTo("letter","T");
        List<Brand> brands = brandMapper.selectByExample(example);
        brands.forEach(a -> System.out.println(a));
    }

    @Test
    public void test1(){
        List<Brand> brands = brandMapper.selectAll();
        List<String> collect = brands.stream().map(a -> a.getName()).collect(Collectors.toList());
        collect.forEach(a -> System.out.println(a));

    }

}
