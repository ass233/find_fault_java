package com.zjjw.zjjwserver.dao;

import com.zjjw.zjjwserver.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface UserMapper {
    int insert(User record);

    int delete(@Param("id") Long id);

    int update(@Param("pojo") User user);

    User getUserById(@Param("id") long id);

    User getByUsername(@Param("name") String name);

    List<User> list(@Param("pojo") User user);

    List<User> listAll(@Param("pojo") User user);

    List<User> listByIds(@Param("ids") List<Long> ids);

    List<User> getAllUser();
}
