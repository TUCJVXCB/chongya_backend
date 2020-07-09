package cn.chongya.chongya.dao;

import cn.chongya.chongya.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptDao {

    @Select("select * from dept where id = #{id}")
    Dept getDeptById(@Param("id") Integer id);

    @Select("select * from dept")
    List<Dept> getAllDept();
}
