package com.qorb.repository;

import com.qorb.model.EquityReceiver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquityReceiverRepository extends JpaRepository<EquityReceiver,Integer>,EquityReceiverRepositoryCustome {
}
