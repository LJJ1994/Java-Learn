package com.option.service;

import com.option.dao.PermissionDao;
import com.option.dao.PermissionDaoImpl;
import com.option.entity.Permission;

public class PermissionServiceImpl implements PermissionService {

    private PermissionDao permissionDao = new PermissionDaoImpl();

    public Permission createPermission(Permission permission) {

        return permissionDao.createPermission(permission);
    }

    public void deletePermission(Long permissionId) {

        permissionDao.deletePermission(permissionId);
    }
}
