package com.qorb.service;

import com.qorb.model.ObjectProject;
import com.qorb.utilkendo.DropDownListItem;

import java.util.List;

public interface IObjectProject {
    List<ObjectProject> findAll();

    List<DropDownListItem> getCategoryAccessDropDown();
}
