package com.exam.examPortalServer.repository;

import com.exam.examPortalServer.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Long> {
}
