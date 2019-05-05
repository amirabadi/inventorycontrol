package com.qorb.controller;

import com.qorb.service.IEquityReceiver;
import com.qorb.utilkendo.DataSourceRequest;
import com.qorb.utilkendo.DataSourceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EquityReceiverController {
    @Autowired
    private IEquityReceiver iEquityReceiver;
    @RequestMapping(value="/baseinformation/equityReceiver/equityReceiver",method = RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView( "baseinformation/equityReceiver/equityReceiver" );
    }
    @RequestMapping(value="/baseinformation/equityReceiver/equityReceiver/read",method = RequestMethod.POST)
    public @ResponseBody
    DataSourceResult getEquityReceiver(@RequestBody DataSourceRequest request) {
        // return imapBusiness.getAllProvince(request);
        // MapBusiness imapBusiness=new MapBusiness();
        DataSourceResult t = iEquityReceiver.getAllEquityReceiver(request);
        return t;
    }
}
