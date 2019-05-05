package com.qorb.repository;

import com.qorb.model.Permission;
import com.qorb.utilkendo.DataSourceRequest;
import com.qorb.utilkendo.DataSourceResult;

public interface PermissionRepositoryCustome {
    DataSourceResult getAllKendo(DataSourceRequest request, Class<Permission> p);
}
