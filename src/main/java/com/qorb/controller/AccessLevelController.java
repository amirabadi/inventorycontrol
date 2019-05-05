package com.qorb.controller;


import com.qorb.service.IAccessLevel;
import com.qorb.service.IEnumData;
import com.qorb.service.IObjectProject;
import com.qorb.service.IRole;
import com.qorb.model.Permission;
import com.qorb.model.Role;
import com.qorb.utilkendo.DataSourceRequest;
import com.qorb.utilkendo.DataSourceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class AccessLevelController {
    @Autowired
    private IAccessLevel iAccessLevel;
    @Autowired
    private IEnumData iEnumData;
    @Autowired
    private IRole iRole;
    @Autowired
    private IObjectProject iObjectProject;
    @RequestMapping(value = "/security/accesslevel",method = RequestMethod.GET)
    public ModelAndView index(Model model)
    {
        model.addAttribute("categoryAccess",iEnumData.getCategoryAccessDropDown());
        model.addAttribute("categoryObject",iObjectProject.getCategoryAccessDropDown());
        model.addAttribute("categoryRole",iRole.getRolesDropDown());
        return new ModelAndView( "security/accesslevel" );
    }

    @RequestMapping(value="/security/AccessLevel/readAccessLevel",method = RequestMethod.POST)
    public @ResponseBody
    DataSourceResult readAccessLevel(@RequestBody DataSourceRequest request){
        DataSourceResult t = iAccessLevel.getAllAccessLevels(request);
        return t;
    }

    @RequestMapping(value = "/security/AccessLevel/createAccessLevel",method = RequestMethod.POST)
    public @ResponseBody
    Permission create(@RequestBody Map<String, Object> model) {
        return iAccessLevel.createAccessLevel(model);
    }
    @RequestMapping(value = "/security/AccessLevel/updateAccessLevel",method = RequestMethod.POST)
    public @ResponseBody Permission update(@RequestBody Map<String, Object> model) {
        return iAccessLevel.updateAccessLevel(model);
    }
    @RequestMapping(value = "/security/AccessLevel/destroyAccessLevel",method = RequestMethod.POST)
    public @ResponseBody Permission delete(@RequestBody Map<String, Object> model){
        return iAccessLevel.deleteAccessLevel(model);
    }
}
