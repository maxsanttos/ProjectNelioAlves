package com.course.project.service;

import com.course.project.model.entity.User;
import com.course.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = repository.findById(id);
        return user.get();
    }
    public User save(User user) {
        return repository.save(user);
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado!");
        }
        repository.deleteById(id);
    }

    public User update(Long id , User user) {
        User entity = repository.getReferenceById(id);
        updateData(entity,user);
        return repository.save(entity);
    }

    private void updateData(User entity, User user){
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }
}
