package com.qorb.repository;

import com.qorb.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer>,RoleRepositoryCustome {

    Role findByIdRole(Integer idRole);
}
