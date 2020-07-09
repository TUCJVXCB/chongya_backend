package cn.chongya.chongya.service.impl;

import cn.chongya.chongya.dao.DeptDao;
import cn.chongya.chongya.dao.UserDao;
import cn.chongya.chongya.entity.Dept;
import cn.chongya.chongya.entity.User;
import cn.chongya.chongya.entity.UserVO;
import cn.chongya.chongya.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private DeptDao deptDao;


    @Override
    public UserVO getUserById(Integer userId) {
        UserVO userVO = new UserVO();
        User user = userDao.getUserById(userId);
        Integer deptId = user.getDeptId();
        Dept dept = deptDao.getDeptById(deptId);

        BeanUtils.copyProperties(user, userVO);
        userVO.setDeptId(deptId);
        userVO.setDeptName(dept.getDeptName());

        return userVO;
    }

    @Override
    public List<UserVO> getAllUsers() {
        List<User> allUsers = userDao.getAllUsers();
        List<UserVO> userVOList = new ArrayList<>();

        for (User user : allUsers) {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(user, userVO);
            Dept dept = deptDao.getDeptById(user.getDeptId());
            userVO.setDeptName(dept.getDeptName());
            userVOList.add(userVO);
        }

        return userVOList;
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int deleteUserById(Integer userId) {
        return userDao.deleteUserById(userId);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }
}
