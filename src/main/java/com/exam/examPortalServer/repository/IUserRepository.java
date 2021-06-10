package com.exam.examPortalServer.repository;

import com.exam.examPortalServer.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
