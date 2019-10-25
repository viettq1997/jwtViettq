package com.iist.vse900.repository.jpa;

import com.iist.vse900.domain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriesJpaRepository extends JpaRepository<Category, Long> {
    Category findFirstById(Long id);
    List<Category> findByIsActive(char isActive);
    List<Category> findByTypeAndIsActive(String type, char isActive);
    boolean existsByCode(String code);
}
