package com.qorb.controller;

import com.qorb.service.IUnit;
import com.qorb.model.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
public class UnitController {

    @Autowired
    private IUnit iUnit;

    @RequestMapping(value = "/baseinformation/unit/unit", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("baseinformation/unit/unit");
    }

    @RequestMapping(value = "/baseinformation/unit/unit/read", method = RequestMethod.POST)
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

    @RequestMapping(value = "/baseinformation/unit/unit/edit", method = RequestMethod.POST)
    public @ResponseBody
    ModelAndView editPage(@RequestParam String nodeval, @RequestParam String nodetxt, Model model) {
        model.addAttribute("unitname", nodetxt);
        model.addAttribute("unitid", nodeval);
        return new ModelAndView("baseinformation/unit/edit");
    }

    @RequestMapping(value = "/baseinformation/unit/unit/doEdit", method = RequestMethod.POST)
    public @ResponseStatus
    ResponseEntity<String> doEdit(@RequestParam String radeId, @RequestParam Boolean check, @RequestParam String rade, @RequestParam String radeNew, Model model) {

        if (check != null && check.equals(true)) {

            iUnit.createUnit(radeId, radeNew);
        } else {
            iUnit.updateUnit(radeId, rade);
        }
        return new ResponseEntity<String>(HttpStatus.OK);
    }
    @RequestMapping(value = "/baseinformation/unit/unit/doDelete", method = RequestMethod.POST)
    public @ResponseStatus
    ResponseEntity<String> doDelete(@RequestParam String radeId) {
        iUnit.deleteUnit(radeId);
       return new ResponseEntity<String>(HttpStatus.OK);
    }
}
