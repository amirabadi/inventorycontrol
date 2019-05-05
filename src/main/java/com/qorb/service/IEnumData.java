package com.qorb.service;

import com.qorb.model.EnumInfo;
import com.qorb.utilkendo.DropDownListItem;

import java.util.List;

public interface IEnumData {
    List<EnumInfo> findByEnumTypeAccess();

    List<DropDownListItem> getCategoryAccessDropDown();
}
