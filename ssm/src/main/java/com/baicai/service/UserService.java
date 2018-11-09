package com.baicai.service;

import com.baicai.pojo.EasyUIPage;

public interface UserService {

    /**
     * 获取用户分页列表
     * @param start
     * @param end
     * @return
     */
    EasyUIPage getUsers(Integer start, Integer end);

}
