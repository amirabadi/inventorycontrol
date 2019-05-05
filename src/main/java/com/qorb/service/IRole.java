package com.qorb.service;

import com.qorb.model.Role;
import com.qorb.utilkendo.DataSourceRequest;
import com.qorb.utilkendo.DataSourceResult;
import com.qorb.utilkendo.DropDownListItem;

import java.util.List;
import java.util.Map;

public interface IRole {
    List<Role> getAllRoles();
    DataSourceResult getAllRoles(DataSourceRequest request);
    Role createRole(Map<String, Object> model);
    Role updateRole(Map<String, Object> model);
    Role deleteRole(Map<String, Object> model);

    List<DropDownListItem> getRolesDropDown();
}
