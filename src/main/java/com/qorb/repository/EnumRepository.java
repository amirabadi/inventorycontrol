package com.qorb.repository;

import com.qorb.model.EnumInfo;
import com.qorb.model.EnumType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnumRepository extends JpaRepository<EnumInfo,Integer> {
    //@Query("select u from EnumInfo u where u.enumType = ?1")
    List<EnumInfo> findByEnumType(EnumType enumType);

    EnumInfo findByIdEnum(Integer idEnum);
}
