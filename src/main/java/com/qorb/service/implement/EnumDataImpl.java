package com.qorb.service.implement;

import com.qorb.model.EnumInfo;
import com.qorb.model.EnumType;
import com.qorb.repository.EnumRepository;
import com.qorb.repository.EnumTypeRepository;
import com.qorb.utilkendo.DropDownListItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnumDataImpl implements IEnumData {
    @Autowired
    private EnumRepository enumRepository;
    @Autowired
    private EnumTypeRepository enumTypeRepository;
    @Override
    @Transactional
    public List<EnumInfo> findByEnumTypeAccess() {
        EnumType enumType=enumTypeRepository.findByIdEnumType(1);
        return enumRepository.findByEnumType(enumType);
    }

    @Override
    public List<DropDownListItem> getCategoryAccessDropDown() {
        List<EnumInfo> t=findByEnumTypeAccess();
        List<DropDownListItem> catgeoryDropDownList=new ArrayList<DropDownListItem>();
        for(EnumInfo e:t){
            catgeoryDropDownList.add(new DropDownListItem(e.getTitle(),String.valueOf(e.getIdEnum())));
        }
        return catgeoryDropDownList;
    }
}
