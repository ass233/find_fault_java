package com.zjjw.zjjwserver.dao;

import com.zjjw.zjjwserver.po.GroupToUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GroupToUserMapper {
    int deleteById(Long id);

    int insert(GroupToUser record);

    GroupToUser selectById(Long id);

    int updateById(GroupToUser record);

	List<GroupToUser> list(@Param("pojo") GroupToUser groupToUser);
}
