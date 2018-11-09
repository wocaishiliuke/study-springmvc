package com.baicai.service.impl;

import com.baicai.mapper.UserMapper;
import com.baicai.pojo.EasyUIPage;
import com.baicai.pojo.User;
import com.baicai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 获取用户分页列表
     * @param start
     * @param end
     * @return
     */
    @Override
    public EasyUIPage getUsers(Integer start, Integer end) {
        List<User> userList = this.userMapper.selectPageList(start, end);
        EasyUIPage easyUIPage = new EasyUIPage();
        easyUIPage.setRows(userList);
        easyUIPage.setTotal((end.longValue() - start.longValue()));
        return easyUIPage;
    }
}
