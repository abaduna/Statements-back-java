package com.abaduna.serch.controller;

import com.abaduna.serch.models.User;
import com.abaduna.serch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUsersByName(@RequestParam String name) {
        List<User> users = userRepository.findByNameIgnoreCaseContaining(name);
        return ResponseEntity.ok(users);
    }
}
