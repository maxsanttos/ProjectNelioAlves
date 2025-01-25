package com.course.project.service;

import com.course.project.model.entity.Category;
import com.course.project.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

   public Category findById(Long id) {
        Optional<Category> category = repository.findById(id);
        return category.get();
   }
}
