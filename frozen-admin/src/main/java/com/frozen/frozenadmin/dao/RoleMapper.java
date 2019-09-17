package com.frozen.frozenadmin.dao;

import com.frozen.frozenadmin.po.Role;
import com.frozen.frozenadmin.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface RoleMapper {
    int insert(Role record);

    int delete(@Param("id") long id);

    int update(@Param("pojo")Role pojo);

    Role getById(@Param("id") long id);

    Role getByName(@Param("name") String name);

    List<Role> list(@Param("pojo")Role pojo);

    List<Role> listAll(@Param("pojo")Role pojo);

    List<Role> listByIds(@Param("ids") List<Long> ids);
}