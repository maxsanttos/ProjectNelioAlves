package com.course.project.service;

import com.course.project.model.entity.User;
import com.course.project.repository.UserRepository;
import com.course.project.service.exceptions.DatabaseException;
import com.course.project.service.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DatabaseException e){
            throw new DatabaseException(e.getMessage());
        }
        
    }

    public User update(Long id , User user) {
        try {
            User entity = repository.getReferenceById(id);
            updateData(entity,user);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User user){
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }
}
