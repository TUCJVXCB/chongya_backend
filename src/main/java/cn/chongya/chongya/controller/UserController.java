package cn.chongya.chongya.controller;

import cn.chongya.chongya.entity.Result;
import cn.chongya.chongya.entity.User;
import cn.chongya.chongya.entity.UserForm;
import cn.chongya.chongya.entity.UserVO;
import cn.chongya.chongya.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/getUser/{id}")
    @ApiOperation("根据Id获得User")
    public Result getUserById(@PathVariable("id") Integer id) {
        if (id <= 0) {
            return new Result<>(400, "非法参数");
        }
        UserVO userVO = userService.getUserById(id);
        if (ObjectUtils.isEmpty(userVO)) {
            return new Result(401, "无此用户");
        }
        return new Result<>(200, "查询成功", userVO);
    }

    @GetMapping("/getAllUsers")
    @ApiOperation("获得所有User")
    public Result<List<UserVO>> getAllUsers() {
        List<UserVO> allUsers = userService.getAllUsers();
        return new Result<>(200, "查询成功", allUsers);
    }

    @PostMapping("/addUser")
    @ApiOperation("添加User")
    public Result addUser(@RequestBody User user) {
        if (ObjectUtils.isEmpty(user)) {
            return new Result(400, "非法参数");
        }
        int i = userService.addUser(user);
        if (i > 0) {
            return new Result(200, "添加成功");
        }
        return new Result(404, "添加失败");
    }

    @DeleteMapping("/deleteUser/{id}")
    @ApiOperation("根据Id删除User")
    public Result deleteUser(@PathVariable("id") Integer id) {
        if (id <= 0) {
            return new Result<>(400, "非法参数");
        }
        int i = userService.deleteUserById(id);
        if (i > 0) {
            return new Result(200, "删除成功");
        }
        return new Result(404, "删除失败");

    }



    @PostMapping("/login")
    @ApiOperation("登陆接口")
    public Result login(@RequestBody UserForm user) {
        String username = user.getUsername();
        String password = user.getPassword();
        if (StringUtils.isEmpty(username)) {
            return new Result<>(404, "用户名为空");
        }

        if (StringUtils.isEmpty(password)) {
            return new Result<>(404, "密码为空");
        }
        User userFromDB = userService.getUserByUsername(username);

        if (userFromDB != null && userFromDB.getPassword().equals(password)) {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(userFromDB, userVO);
            userVO.setToken(String.valueOf(userFromDB.getId()));
            return new Result<>(200, "登陆成功", userVO);
        }
        return new Result<>(400, "密码错误");
    }

}
