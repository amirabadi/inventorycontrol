package com.qorb.service;

import com.qorb.model.User;
import com.qorb.utilkendo.DataSourceRequest;
import com.qorb.utilkendo.DataSourceResult;

import java.util.List;
import java.util.Map;

public interface IUser {
    List<User> getAllUsers();

    DataSourceResult getAllUsers(DataSourceRequest request);
    User createUser(Map<String, Object> model);
    User updateUser(Map<String, Object> model);
    User deleteUser(Map<String, Object> model);

    void createUser(String radeId, String userNameId, String passId,Integer idRole);

    void updateUser(Integer editId, String radeId, String userNameId, String passId,Integer idRole);

    User findByIdUser(Integer editId);
}