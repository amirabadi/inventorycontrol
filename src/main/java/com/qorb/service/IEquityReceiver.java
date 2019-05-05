package com.qorb.service;

import com.qorb.model.EquityReceiver;
import com.qorb.utilkendo.DataSourceRequest;
import com.qorb.utilkendo.DataSourceResult;

import java.util.Map;

public interface IEquityReceiver {
    DataSourceResult getAllEquityReceiver(DataSourceRequest request);

    EquityReceiver createEquityReceiver(Map<String, Object> model);

    EquityReceiver updateEquityReceiver(Map<String, Object> model);

    EquityReceiver deleteEquityReceiver(Map<String, Object> model);
}
