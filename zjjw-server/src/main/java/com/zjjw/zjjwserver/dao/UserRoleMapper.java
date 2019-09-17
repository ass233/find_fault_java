package com.zjjw.zjjwserver.dao;

        import com.zjjw.zjjwserver.po.UserRole;

        import java.util.List;

        import org.apache.ibatis.annotations.Mapper;
        import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRoleMapper {
    int insert(UserRole record);

    int delete(@Param("id") Long id);

    List<UserRole> getByUserId(@Param("userId") long userId);

    List<UserRole> getByRoleId(@Param("roleId") long roleId);

    int deleteByUserId(@Param("userId") long userId);

    int deleteByRoleId(@Param("roleId") long roleId);

}
