package cn.chongya.chongya.dao;

import cn.chongya.chongya.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("select * from user where id = #{userId}")
    User getUserById(@Param("userId") Integer userId);

    @Select("select * from user")
    List<User> getAllUsers();

    @Select("select * from user where username = #{username}")
    User getUserByUsername(@Param("username") String username);

    @Insert("insert into user (username, age, password, dept_id, role, avatar, position)values(#{username}, #{age}, #{password}, #{deptId}, #{role}, #{avatar}, #{position})")
    int addUser(User user);

    @Delete("delete from user where id = #{userId}")
    int deleteUserById(@Param("userId") Integer userId);

    @Update("update user set username = #{username}, age = #{age}, password = #{password}, deptId = #{dept_id}, role = #{role}, avatar = #{avatar}, position = #{position} where id = #{Id}")
    int updateUser(User user);
}
