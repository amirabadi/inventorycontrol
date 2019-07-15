package com.qorb.service.implement;

import com.qorb.model.EquityReceiver;
import com.qorb.repository.EquityReceiverRepository;
import com.qorb.utilkendo.DataSourceRequest;
import com.qorb.utilkendo.DataSourceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EquityReceiverImpl implements IEquityReceiver{
    @Autowired
    private EquityReceiverRepository equityReceiverRepository;
    @Override
    public DataSourceResult getAllEquityReceiver(DataSourceRequest request) {
        return equityReceiverRepository.getAllKendo(request,EquityReceiver.class);
    }

    @Override
    public EquityReceiver createEquityReceiver(Map<String, Object> model) {
        return null;
    }

    @Override
    public EquityReceiver updateEquityReceiver(Map<String, Object> model) {
        return null;
    }

    @Override
    public EquityReceiver deleteEquityReceiver(Map<String, Object> model) {
        return null;
    }
}
