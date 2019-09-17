package cn.chenzw.springboot.two.domain.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sys_user")
public class SysUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 帐号
     */
    private String username;

    /**
     * 名称（昵称或者真实姓名，不同系统不同定义）
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 加密密码的盐
     */
    private String salt;

    /**
     * 状态：0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定
     */
    private byte state;
}
