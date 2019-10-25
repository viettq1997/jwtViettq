package com.iist.vse900.repository.impl;

import com.iist.vse900.domain.model.Category;
import com.iist.vse900.repository.CategoriesRepository;
import com.iist.vse900.repository.jpa.CategoriesJpaRepository;
import com.iist.vse900.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoriesRepositoryImpl implements CategoriesRepository {

    @Autowired
    CategoriesJpaRepository categoriesJpaRepository;

    @Override
    public List<Category> getAll() {
        return categoriesJpaRepository.findByIsActive('Y');
    }

    @Override
    public List<Category> getCategoryByType(String type) {
        return categoriesJpaRepository.findByTypeAndIsActive(type, 'Y');
    }

    @Override
    public boolean save(Category category) {
        if (category.getCode() == null) {
            while (true) {
                category.setCode(StringUtils.generateRandomString(20));
                if (!categoriesJpaRepository.existsByCode(category.getCode())) {
                    break;
                }
            }
        }
        categoriesJpaRepository.save(category);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        Category category = categoriesJpaRepository.findFirstById(id);
        return delete(category);
    }

    @Override
    public boolean delete(Category category) {
        if (category != null && category.getId() != null) {
            category.setIsActive('N');
            categoriesJpaRepository.save(category);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Category category) {
        if (category.getId() != null) {
            categoriesJpaRepository.save(category);
            return true;
        }
        return false;
    }
}
