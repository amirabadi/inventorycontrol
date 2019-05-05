package com.qorb.repository;

import com.qorb.model.ObjectProject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjectProjectRepository extends JpaRepository<ObjectProject,Integer> {
    ObjectProject findByIdObjectProject(Integer idObjectProject);
}
