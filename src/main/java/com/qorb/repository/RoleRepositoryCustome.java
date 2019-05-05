package com.qorb.repository;

import com.qorb.model.Role;
import com.qorb.utilkendo.DataSourceRequest;
import com.qorb.utilkendo.DataSourceResult;

public interface RoleRepositoryCustome {
    DataSourceResult getAllKendo(DataSourceRequest request, Class<Role> p);
}
