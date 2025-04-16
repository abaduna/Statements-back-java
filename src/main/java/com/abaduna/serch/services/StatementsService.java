package com.abaduna.serch.services;

import com.abaduna.serch.models.StatementRequest;
import com.abaduna.serch.models.Statements;

import java.util.List;
import java.util.Optional;

public interface StatementsService {
    List<Statements> getAllStatements();
    Optional<Statements> getStatementById(Long id);
    Statements createStatement(StatementRequest request);
    boolean deleteStatement(Long id);
    List<Statements> getStatementsByUserName(String name);
}
