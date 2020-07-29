package com.option.dao;

import com.option.entity.Permission;

public interface PermissionDao {

    public Permission createPermission(Permission permission);

    public void deletePermission(Long permissionId);

}
