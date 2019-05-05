package com.qorb.controller;


import com.qorb.model.Role;
import com.qorb.service.IRole;
import com.qorb.service.IUnit;
import com.qorb.service.IUser;
import com.qorb.model.Unit;
import com.qorb.model.User;
import com.qorb.utilkendo.DataSourceRequest;
import com.qorb.utilkendo.DataSourceResult;
import com.qorb.utilkendo.DropDownListItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private IUser iUser;
    @Autowired
    private IUnit iUnit;
    @Autowired
    private IRole iRole;
    @RequestMapping(value = "/security/user/user",method = RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("security/user/user");
    }
    @RequestMapping(value = "/security/user/user/readuser",method = RequestMethod.POST)
    public @ResponseBody
    DataSourceResult getUser(@RequestBody DataSourceRequest request) {
        // return imapBusiness.getAllProvince(request);
        // MapBusiness imapBusiness=new MapBusiness();
        DataSourceResult t = iUser.getAllUsers(request);
        return t;
    }

    @RequestMapping(value = "/security/user/user/read", method = RequestMethod.POST)
    public @ResponseBody
    List<Unit> read(@RequestBody Map<String, Object> model) {
        if (model.size() == 0) {
            List<Unit> t = iUnit.getListByUnitId(null);
            return t;
        } else {
            List<Unit> t = iUnit.getListByUnitId((Integer) model.get("idUnit"));
            return t;
        }
    }

    @RequestMapping(value = "/security/user/user/edit",method = RequestMethod.POST)
    public @ResponseBody ModelAndView edit( @RequestParam Integer editId, Model model) {
        User u=iUser.findByIdUser(editId);
        List<DropDownListItem> dropDownListItems=iRole.getRolesDropDown();
        model.addAttribute("editValue",editId);
        model.addAttribute("userNameId",u.getUserName());
        model.addAttribute("passId",u.getPassword());
        model.addAttribute("radeId",u.getUnit());
        model.addAttribute("roleIds",u.getRoles().iterator().next().getIdRole());
        model.addAttribute("allRoles",dropDownListItems);
        model.addAttribute("paths","[1,2,22]");
        return new ModelAndView("security/user/edit");
    }

    @RequestMapping(value = "/security/user/user/create",method = RequestMethod.POST)
    public @ResponseBody ModelAndView create( Model model) {
        model.addAttribute("editValue",0);
        return new ModelAndView("security/user/edit");
    }
   /* @RequestMapping(value = "/security/user/user/createuser",method = RequestMethod.POST)
    public @ResponseBody
    User create(@RequestBody Map<String, Object> model) {
        return iUser.createUser(model);
    }*/
    @RequestMapping(value = "/security/user/user/updateuser",method = RequestMethod.POST)
    public @ResponseBody User update(@RequestBody Map<String, Object> model) {
        return iUser.updateUser(model);
    }
    @RequestMapping(value = "/security/user/user/destroyuser",method = RequestMethod.POST)
    public @ResponseBody User delete(@RequestBody Map<String, Object> model){
        return iUser.deleteUser(model);
    }
    @RequestMapping(value = "/security/user/user/doAdd",method = RequestMethod.POST)
    public @ResponseStatus ResponseEntity<String> doAdd(@RequestParam String radeId, @RequestParam Integer editId,
                                                      @RequestParam String userNameId, @RequestParam String passId,
                                                        @RequestParam Integer idRole   ) {
        //iUser.updateUser();
        if(editId==null)
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        if(editId.equals(0)){
            iUser.createUser(radeId,userNameId,passId,idRole);
        }
        else{
            iUser.updateUser(editId,radeId,userNameId,passId,idRole);
        }
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}

