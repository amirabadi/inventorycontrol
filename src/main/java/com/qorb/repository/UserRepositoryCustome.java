package com.qorb.repository;

import com.qorb.model.User;
import com.qorb.utilkendo.DataSourceRequest;
import com.qorb.utilkendo.DataSourceResult;

public interface UserRepositoryCustome {
    DataSourceResult getAllKendo(DataSourceRequest request, Class<User> p);
}
