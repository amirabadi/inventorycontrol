package com.qorb.service.implement;

import com.qorb.model.Permission;
import com.qorb.repository.EnumRepository;
import com.qorb.repository.ObjectProjectRepository;
import com.qorb.repository.PermissionRepository;
import com.qorb.repository.RoleRepository;
import com.qorb.service.IAccessLevel;
import com.qorb.utilkendo.DataSourceRequest;
import com.qorb.utilkendo.DataSourceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;

@Service
public class AccessLevelImpl implements IAccessLevel {
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private EnumRepository enumRepository;
    @Autowired
    private ObjectProjectRepository objectProjectRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public DataSourceResult getAllAccessLevels(DataSourceRequest request) {
        return permissionRepository.getAllKendo(request, Permission.class);
    }

    @Override
    @Transactional
    public Permission createAccessLevel(Map<String, Object> model) {
        Permission permission=fillValuesObject(model);
        permission.setInsertDate(new Date());
        permissionRepository.save(permission);
        return permission;
    }

    @Override
    public Permission updateAccessLevel(Map<String, Object> model) {
        return null;
    }

    @Override
    public Permission deleteAccessLevel(Map<String, Object> model) {
        return null;
    }

    private Permission fillValuesObject(Map<String, Object> model) {
        Permission person = new Permission();
        person.setAnEnum(enumRepository.findByIdEnum(Integer.valueOf(model.get("idEnum").toString())));
        person.setRole(roleRepository.findByIdRole(Integer.valueOf(model.get("idRole").toString())));
        String t=model.get("idObjectProject").toString();
        person.setObjectProject(objectProjectRepository.findByIdObjectProject(Integer.valueOf(t)));
        return person;
    }
}
