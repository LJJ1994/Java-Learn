package com.option.service;

import com.option.entity.Permission;

public interface PermissionService {
    public Permission createPermission(Permission permission);
    public void deletePermission(Long permissionId);
}
