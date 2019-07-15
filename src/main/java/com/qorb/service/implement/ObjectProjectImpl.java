package com.qorb.service.implement;

import com.qorb.model.ObjectProject;
import com.qorb.repository.ObjectProjectRepository;
import com.qorb.service.IObjectProject;
import com.qorb.utilkendo.DropDownListItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObjectProjectImpl implements IObjectProject {
    @Autowired
    private ObjectProjectRepository objectProjectRepository;
    @Override
    public List<ObjectProject> findAll() {
        return objectProjectRepository.findAll();
    }

    @Override
    public List<DropDownListItem> getCategoryAccessDropDown() {
        List<ObjectProject> t=findAll();
        List<DropDownListItem> catgeoryDropDownList=new ArrayList<DropDownListItem>();
        for(ObjectProject e:t){
            catgeoryDropDownList.add(new DropDownListItem(e.getObjectName(),String.valueOf(e.getIdObjectProject())));
        }
        return catgeoryDropDownList;
    }

}
