package com.qorb.controller;

import com.qorb.NationalCode;
import com.qorb.service.IPerson;
import com.qorb.model.Person;
import com.qorb.utilkendo.DataSourceRequest;
import com.qorb.utilkendo.DataSourceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class PersonController {
    @Autowired
    private IPerson iPerson;
    @RequestMapping(value = "/security/person",method = RequestMethod.GET)
    @PreAuthorize("hasPermission(this,'view')")
    public ModelAndView index(){
        return new ModelAndView( "security/person" );
    }

    @PreAuthorize("hasPermission(this,'insert')")
    @RequestMapping(value = "/security/person/readperson1",method = RequestMethod.POST)
    public @ResponseBody
    void getRole1() {
      return;
    }

    @PreAuthorize("hasPermission(this,'insert')")
    @RequestMapping(value = "/security/person/readperson",method = RequestMethod.POST)
    public @ResponseBody
    DataSourceResult getRole(@RequestBody DataSourceRequest request) {
        // return imapBusiness.getAllProvince(request);
        // MapBusiness imapBusiness=new MapBusiness();
        DataSourceResult t = iPerson.getAllPersons(request);
        return t;
    }
    @RequestMapping(value = "/security/person/createperson",method = RequestMethod.POST)
    public @ResponseBody Person create(@RequestBody Map<String, Object> model) {
        return iPerson.createPerson(model);
    }
    @RequestMapping(value = "/security/person/updateperson",method = RequestMethod.POST)
    public @ResponseBody Person update(@RequestBody Map<String, Object> model) {
        return iPerson.updatePerson(model);
    }
    @RequestMapping(value = "/security/person/destroyperson",method = RequestMethod.POST)
    public @ResponseBody Person delete(@RequestBody Map<String, Object> model){
            return iPerson.deletePerson(model);
    }
    @RequestMapping(value = "/security/person/check",method = RequestMethod.POST)
    public @ResponseBody boolean checkNationalCode(@RequestBody String nationalCode){
        return NationalCode.isValidNationalCode(nationalCode);
    }
}
