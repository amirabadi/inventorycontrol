package com.qorb.service;

import com.qorb.model.Unit;
import com.qorb.repository.UnitRepository;
import com.qorb.utilkendo.DataSourceRequest;
import com.qorb.utilkendo.DataSourceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UnitImpl implements IUnit {
    @Autowired
    private UnitRepository unitRepository;
    @Override
    public List<Unit> getAllUnits() {
        return unitRepository.findAll();
    }

    @Override
    @Transactional
    public Unit createUnit(String radeId, String radeNew) {
        Unit unitParent=unitRepository.findByIdUnit(Integer.valueOf(radeId));
        Unit newUnit=new Unit();
        newUnit.setActive(true);
        newUnit.setUnitName(radeNew);
        newUnit.setInsertDate(new Date());
        newUnit.setParent(unitParent);
        return unitRepository.save(newUnit);
    }

    @Override
    public Unit updateUnit(String radeId,String rade) {
        Unit unit=unitRepository.findByIdUnit(Integer.valueOf(radeId));
        unit.setUnitName(rade);
        unit.setUpdateDate(new Date());
        return unitRepository.saveAndFlush(unit);
    }

    @Override
    @Transactional
    public void deleteUnit(String radeId) {
        Unit deleteUnit=unitRepository.findByIdUnit(Integer.valueOf(radeId));
        deleteUnit.setParent(null);
        unitRepository.delete(deleteUnit);
    }

    @Override
    public List<Unit> getListByUnitId(Integer id) {
        if(id==null){
            Unit u=unitRepository.findByIdUnit(1);
            List<Unit> t=new ArrayList<Unit>();
            t.add(u);
            return t;
        }
        else
        return unitRepository.findByParent(unitRepository.findByIdUnit(id));
    }
}
