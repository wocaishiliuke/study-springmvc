package com.baicai.mapper;

import com.baicai.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.CollectionUtils;

import java.util.List;

//测试Spring和Mybatis的整和
public class UserMapperTest {

    private UserMapper userMapper;

    @Before
    public void setUp() throws Exception {
        // 整合mybatis的配置文件也要读取
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext*.xml");
        userMapper = context.getBean(UserMapper.class);
        System.out.println(userMapper);
    }

    @Test
    public void testSelectList() {
        List<User> users = userMapper.selectPageList(0,5);
        if (!CollectionUtils.isEmpty(users)) {
            for (User user : users) {
                System.out.println(user.toString());
            }
        }
    }
}
