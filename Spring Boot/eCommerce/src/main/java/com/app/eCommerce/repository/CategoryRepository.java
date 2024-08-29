package com.app.eCommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.eCommerce.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
