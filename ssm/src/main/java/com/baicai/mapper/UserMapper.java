package com.baicai.mapper;

import com.baicai.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 获取用户分页列表
     * @param start
     * @param end
     * @return
     */
    List<User> selectPageList(@Param("start") Integer start, @Param("end") Integer end);
}
