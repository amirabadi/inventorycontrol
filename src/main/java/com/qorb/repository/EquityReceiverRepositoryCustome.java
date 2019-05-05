package com.qorb.repository;

import com.qorb.model.EquityReceiver;
import com.qorb.utilkendo.DataSourceRequest;
import com.qorb.utilkendo.DataSourceResult;

public interface EquityReceiverRepositoryCustome  {
    DataSourceResult getAllKendo(DataSourceRequest request, Class<EquityReceiver> p);
}
