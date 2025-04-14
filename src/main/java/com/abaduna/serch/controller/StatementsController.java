package com.abaduna.serch.controller;

import com.abaduna.serch.models.StatementRequest;
import com.abaduna.serch.models.Statements;
import com.abaduna.serch.models.User;
import com.abaduna.serch.repository.StatementsRepository;
import com.abaduna.serch.repository.UserRepository;
import com.abaduna.serch.services.StatementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/statements")
public class StatementsController {

    @Autowired
    private StatementsService statementsService;

    @GetMapping
    public List<Statements> getAllStatements() {
        return statementsService.getAllStatements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Statements> getStatementById(@PathVariable Long id) {
        return statementsService.getStatementById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Statements> createStatement(@RequestBody StatementRequest request) {
        Statements created = statementsService.createStatement(request);
        return ResponseEntity.ok(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatement(@PathVariable Long id) {
        if (statementsService.deleteStatement(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
