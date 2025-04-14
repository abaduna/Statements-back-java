package com.abaduna.serch.repository;

import com.abaduna.serch.models.Statements;
import com.abaduna.serch.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatementsRepository extends JpaRepository<Statements, Long> {}


