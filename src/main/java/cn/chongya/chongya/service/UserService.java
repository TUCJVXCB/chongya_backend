package cn.chongya.chongya.service;

import cn.chongya.chongya.entity.User;
import cn.chongya.chongya.entity.UserVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserVO getUserById(@Param("userId") Integer userId);

    List<UserVO> getAllUsers();

    int addUser(User user);

    int deleteUserById(@Param("userId") Integer userId);

    User getUserByUsername(@Param("username") String username);
}
