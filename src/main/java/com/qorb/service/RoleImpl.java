package com.qorb.service;

import com.qorb.model.EnumInfo;
import com.qorb.model.Role;
import com.qorb.repository.RoleRepository;
import com.qorb.utilkendo.DataSourceRequest;
import com.qorb.utilkendo.DataSourceResult;
import com.qorb.utilkendo.DropDownListItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class RoleImpl implements IRole {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public DataSourceResult getAllRoles(DataSourceRequest request) {
        return roleRepository.getAllKendo(request,Role.class);
    }

    @Override
    public Role createRole(Map<String, Object> model) {
        Role role=fillValuesObject(model);
        role.setInsertDate(new Date());
        roleRepository.save(role);
        return role;
    }

    private Role fillValuesObject(Map<String,Object> model) {
        Role role=new Role();

        role.setRoleName((String) model.get("roleName"));
        role.setRoleNamePersian((String) model.get("roleNamePersian"));
        return role;
    }

    @Override
    public Role updateRole(Map<String, Object> model) {
        Role role=fillValuesObject(model);
        role.setIdRole((Integer)model.get("idRole"));
        role.setUpdateDate(new Date());
        roleRepository.save(role);
        return role;
    }

    @Override
    public Role deleteRole(Map<String, Object> model) {
        Role role=fillValuesObject(model);
        role.setIdRole((Integer)model.get("idRole"));
        roleRepository.delete(role);
        return null;
    }

    @Override
    public List<DropDownListItem> getRolesDropDown() {
        List<Role> roleList=getAllRoles();
        List<DropDownListItem> roleDropDownList=new ArrayList<DropDownListItem>();
        for(Role e:roleList){
            roleDropDownList.add(new DropDownListItem(e.getRoleName(),String.valueOf(e.getIdRole())));
        }
        return roleDropDownList;
    }
}
