package com.itheima.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: LJJ
 * @Program: mybatis-day02
 * @Description:
 * @Create: 2020-05-09 20:46:46
 * @Modified By:
 */
public class Role implements Serializable {
    private String roleId;
    private String roleName;
    private String roleDesc;

    private List<User> users;

    @Override
    public String toString() {
        return "Role{" +
                "roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", users=" + users +
                '}';
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}
