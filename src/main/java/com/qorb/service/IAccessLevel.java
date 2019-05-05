package com.qorb.service;

import com.qorb.model.Permission;
import com.qorb.utilkendo.DataSourceRequest;
import com.qorb.utilkendo.DataSourceResult;

import java.util.Map;

public interface IAccessLevel {
    DataSourceResult getAllAccessLevels(DataSourceRequest request);

    Permission createAccessLevel(Map<String, Object> model);

    Permission updateAccessLevel(Map<String, Object> model);

    Permission deleteAccessLevel(Map<String, Object> model);
}
