package cn.chenzw.springboot.two.domain.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Table(name = "sys_user")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 用户邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 登录失败次数
     */
    private Integer faileLogins;

    /**
     * 最后登录时间
     */
    private Date lastLoginTime;

    /**
     * 最后登录的IP
     */
    private String lastLoginIp;

    private Date createTime;


    private List<SysRole> sysRoles;


    /**
     * 状态：0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定
     */
    private byte state;


}
