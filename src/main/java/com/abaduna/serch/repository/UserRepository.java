package com.abaduna.serch.repository;

import com.abaduna.serch.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByNameIgnoreCaseContaining(String name);

}