package com.iist.vse900.service;

import com.iist.vse900.domain.model.Category;

import java.util.List;

public interface CategoriesService {
    List<Category> getAll();
    List<Category> getCategoryByType(String type);
    boolean save(Category category);
    boolean delete(Long id);
    boolean delete(Category category);
    boolean update(Category category);
}
