package com.qorb.repository;

import com.qorb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer>,UserRepositoryCustome {
User findByIdUser(Integer id);

    User findByUserName(String username);
}

