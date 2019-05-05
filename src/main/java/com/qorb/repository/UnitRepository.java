package com.qorb.repository;

import com.qorb.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UnitRepository extends JpaRepository<Unit, Integer> {
    List<Unit> findByParent(Unit unit);

    Unit findByIdUnit(Integer id);

}
