package com.qorb.repository;

import com.qorb.model.EnumType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnumTypeRepository extends JpaRepository<EnumType,Integer> {
    EnumType findByIdEnumType(int i);
}
