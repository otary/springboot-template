package cn.chenzw.springboot.two.domain.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author chenzw
 */
@Table(name = "sys_permission")
public class SysPermission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 权限名称
     */
    private String permissionName;

    /**
     * 资源类型，[menu|button]
     */
    @Column(columnDefinition = "enum('menu','button')")
    private String type;

    /**
     * 资源路径
     */
    private String url;

    /**
     * 权限字符串
     */
    private String permission;

    /**
     * 父编号
     */
    private Long parentId;

    /**
     * 父编号列表
     */
    private String parentIds;

    /**
     * 权限描述
     */
    private String description;


    /**
     * 是否可用, 1：可用, 0: 不可用
     */
    private Boolean available = Boolean.FALSE;

    /**
     * 排序
     */
    private Integer sortId;

}
