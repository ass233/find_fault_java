package com.zjjw.zjjwserver.dao;

import com.zjjw.zjjwserver.po.GroupToUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GroupToUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GroupToUser record);

    int insertSelective(GroupToUser record);

    GroupToUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GroupToUser record);

    int updateByPrimaryKey(GroupToUser record);
}
