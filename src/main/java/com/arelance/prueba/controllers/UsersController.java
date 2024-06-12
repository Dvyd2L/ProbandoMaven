package com.arelance.prueba.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arelance.prueba.models.User;
import com.arelance.prueba.services.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UsersController {

  @Autowired
  private UserService userService;

  @GetMapping
  public ResponseEntity<List<User>> getAll() {
    return ResponseEntity.ok(userService.get());
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getById(@PathVariable int id) {
    Optional<User> user = userService.getById(id);
    return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
  }

  @PostMapping
  public ResponseEntity<User> create(@RequestBody User user) {
    userService.create(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(user);
  }

  @PutMapping("/{id}")
  public ResponseEntity<User> update(@PathVariable int id, @RequestBody User user) {
    return userService.update(user) 
      ? ResponseEntity.ok(user) 
      : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<User> delete(@PathVariable int id) {
    return userService.softDelete(id) 
      ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() 
      : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
  }
}
