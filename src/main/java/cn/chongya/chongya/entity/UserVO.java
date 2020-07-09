package cn.chongya.chongya.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class UserVO extends User {

    @ApiModelProperty("用户Id")
    private Integer id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("用户年龄")
    private Integer age;

    @ApiModelProperty("用户密码")
    private String password;

    @ApiModelProperty("用户部门Id")
    private Integer deptId;

    @ApiModelProperty("用户角色")
    private Integer role;

    @ApiModelProperty("部门名称")
    private String deptName;

    @ApiModelProperty("用户头像")
    private String avatar;

    @ApiModelProperty("用户角色")
    private String position;

    private String token;
}
