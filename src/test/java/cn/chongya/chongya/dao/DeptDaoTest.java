package cn.chongya.chongya.dao;

import cn.chongya.chongya.entity.Dept;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DeptDaoTest {

    @Autowired
    private DeptDao deptDao;

    @Test
    void getDeptById() {
        Dept deptById = deptDao.getDeptById(1);
        System.out.println(deptById);
    }

    @Test
    void getAllDept() {
        List<Dept> allDept = deptDao.getAllDept();
        System.out.println(allDept);
    }
}
