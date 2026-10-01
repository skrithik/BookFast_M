package com.bookfast.bookfast_backend.controller;

import com.bookfast.bookfast_backend.dto.CreateUserRequest;
import com.bookfast.bookfast_backend.entity.User;
import com.bookfast.bookfast_backend.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody CreateUserRequest request) {
        User user = new User(
                request.getName(),
                request.getEmail(),
                request.getPassword()
        );

        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .orElseThrow();
    }
}