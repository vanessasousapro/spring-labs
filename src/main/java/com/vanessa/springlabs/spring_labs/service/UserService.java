package com.vanessa.springlabs.spring_labs.service;

import com.vanessa.springlabs.spring_labs.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final List<User> users = new ArrayList<>();
    private Long nextId = 1L;

    public List<User> getUserList() {
        return users;
    }

    public Optional<User> getUserById(long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    public User createUser(User user) {
        user.setId(nextId++);
        users.add(user);
        return user;
    }

    public Optional<User> updateUser(Long id, User updateUser) {
        return getUserById(id).map(user -> {
            user.setName(updateUser.getName());
            user.setEmail(updateUser.getEmail());
            return user;
        });
    }

    public boolean deleteUser(Long id) {
        return users.removeIf(user -> user.getId().equals(id));
    }
}
