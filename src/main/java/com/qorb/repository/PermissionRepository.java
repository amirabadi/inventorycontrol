package com.qorb.repository;

import com.qorb.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission,Integer>,PermissionRepositoryCustome {
}
