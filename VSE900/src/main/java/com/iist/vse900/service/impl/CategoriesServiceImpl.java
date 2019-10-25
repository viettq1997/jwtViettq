package com.iist.vse900.service.impl;

import com.iist.vse900.domain.model.Category;
import com.iist.vse900.repository.CategoriesRepository;
import com.iist.vse900.service.CategoriesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class CategoriesServiceImpl implements CategoriesService {

    @Autowired
    CategoriesRepository categoriesRepository;

    @Override
    public List<Category> getAll() {
        return categoriesRepository.getAll();
    }

    @Override
    public List<Category> getCategoryByType(String type) {
        return categoriesRepository.getCategoryByType(type);
    }

    @Override
    public boolean save(Category category) {
        return categoriesRepository.save(category);
    }

    @Override
    public boolean delete(Long id) {
        return categoriesRepository.delete(id);
    }

    @Override
    public boolean delete(Category category) {
        return categoriesRepository.delete(category);
    }

    @Override
    public boolean update(Category category) {
        return categoriesRepository.update(category);
    }
}
