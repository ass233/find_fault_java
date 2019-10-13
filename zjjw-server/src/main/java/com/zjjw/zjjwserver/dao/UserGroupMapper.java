package com.zjjw.zjjwserver.dao;

import com.zjjw.zjjwserver.po.UserGroup;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserGroupMapper {
    int deleteById(Long id);

    void insert(UserGroup record);

    int insertSelective(UserGroup record);

    UserGroup selectById(Long id);

    int updateByIdSelective(UserGroup record);

    int updateById(UserGroup record);
}
