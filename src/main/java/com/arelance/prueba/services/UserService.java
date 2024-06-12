package com.arelance.prueba.services;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.arelance.prueba.models.User;

@Service
public class UserService extends GenericCrudService<User, Integer> {

  public UserService() {
    super();

    User one = new User("José", "Pérez", "12345678A");
    one.setId(1);
    one.setCreatedTimeUtc(super.getCurrentTimeUtc());

    User two = new User("María", "López", "23456789B");
    two.setId(2);
    two.setCreatedTimeUtc(super.getCurrentTimeUtc());

    User three = new User("Perreo", "Sánchez", "34567890C");
    three.setId(3);
    three.setCreatedTimeUtc(super.getCurrentTimeUtc());

    records.addAll(Arrays.asList(one, two,three));
  }

  @Override
  public void create(User record) {
    int nextId = records.stream()
        .max(Comparator.comparingInt(User::getId))
        .map(userWithMaxId -> userWithMaxId.getId() + 1)
        .orElse(1); // Si la lista está vacía, empezamos con el ID 1
    record.setId(nextId);
    super.create(record);
  }

  @Override
  public boolean update(User user) {
    boolean result = false;
    Optional<User> existingUser = this.getById(user.getId());
    if (existingUser.isPresent()) {
      User updatedUser = existingUser.get();
      updatedUser.setNombre(user.getNombre());
      updatedUser.setApellido(user.getApellido());
      updatedUser.setDni(user.getDni());
      result = super.update(updatedUser);
    }
    return result;
  }
}
