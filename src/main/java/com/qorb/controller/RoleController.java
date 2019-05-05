package com.qorb.controller;


import com.qorb.service.IRole;
import com.qorb.model.Role;
import com.qorb.utilkendo.DataSourceRequest;
import com.qorb.utilkendo.DataSourceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.sql.DataSource;
import java.util.Map;

@Controller
public class RoleController {
    @Autowired
    private IRole iRole;
    
    @RequestMapping(value = "/security/role",method = RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView( "security/role" );
    }
    
    @RequestMapping(value="/security/Role/readRole",method = RequestMethod.POST)
    public @ResponseBody
    DataSourceResult getRole(@RequestBody DataSourceRequest request){
        DataSourceResult t = iRole.getAllRoles(request);
        return t;
    }

    @RequestMapping(value = "/security/Role/createRole",method = RequestMethod.POST)
    public @ResponseBody
    Role create(@RequestBody Map<String, Object> model) {
        return iRole.createRole(model);
    }
    @RequestMapping(value = "/security/Role/updateRole",method = RequestMethod.POST)
    public @ResponseBody Role update(@RequestBody Map<String, Object> model) {
        return iRole.updateRole(model);
    }
    @RequestMapping(value = "/security/Role/destroyRole",method = RequestMethod.POST)
    public @ResponseBody Role delete(@RequestBody Map<String, Object> model){
        return iRole.deleteRole(model);
    }
}
