package com.abaduna.serch.repository;

import com.abaduna.serch.models.Statements;
import com.abaduna.serch.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StatementsRepository extends JpaRepository<Statements, Long> {
    List<Statements> findByUser_NameContainingIgnoreCase(String name);
}


