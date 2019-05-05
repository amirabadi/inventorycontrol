package com.qorb.service;

import com.qorb.model.Unit;
import com.qorb.utilkendo.DataSourceRequest;
import com.qorb.utilkendo.DataSourceResult;

import java.util.List;
import java.util.Map;

public interface IUnit {
    List<Unit> getAllUnits();

    Unit createUnit(String radeId, String radeNew);
    Unit updateUnit(String radeId, String rade);
    void deleteUnit(String radeId);

    List<Unit> getListByUnitId(Integer id);


}
