package com.voytenko.repositories;

import com.voytenko.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category getByName(String name);
}
