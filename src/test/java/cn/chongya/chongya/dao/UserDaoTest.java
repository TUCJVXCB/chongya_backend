package cn.chongya.chongya.dao;

import cn.chongya.chongya.entity.User;
import io.swagger.annotations.ApiOperation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    void getAllUsers() {
        List<User> allUsers = userDao.getAllUsers();
        System.out.println(allUsers);
    }

    @Test
    void addUser() {
        User user = new User();
        user.setUsername("ds");
        user.setPassword("sda");
        user.setDeptId(1);
        user.setAge(12);
        user.setRole(1);
        user.setPosition("后端");
        userDao.addUser(user);
    }

    @Test
    void deleteUserById() {
        userDao.deleteUserById(2);
    }

    @Test
    void editTest() {
        User user = new User();
        user.setUsername("ds");
        user.setPassword("sda");
        user.setDeptId(1);
        user.setAge(12);
        user.setRole(1);
        user.setPosition("前端");
        userDao.updateUser(user);
    }
}
