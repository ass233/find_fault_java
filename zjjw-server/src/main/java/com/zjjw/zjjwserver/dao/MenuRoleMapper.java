package com.zjjw.zjjwserver.dao;

import com.zjjw.zjjwserver.po.MenuRole;
import com.zjjw.zjjwserver.po.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuRoleMapper {

    int insert(MenuRole record);

    int delete(@Param("id") Long id);

    List<MenuRole> getByMenuId(@Param("menuId") long menuId);

    List<MenuRole> getByRoleId(@Param("roleId") long roleId);

    int deleteByMenuId(@Param("menuId") long menuId);

    int deleteByRoleId(@Param("roleId") long roleId);

}
