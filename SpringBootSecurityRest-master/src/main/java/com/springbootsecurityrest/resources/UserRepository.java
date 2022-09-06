package com.springbootsecurityrest.resources;

import com.springbootsecurityrest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserRepository extends JpaRepository<User,Long> {


    User getByLogin(String login);
}
