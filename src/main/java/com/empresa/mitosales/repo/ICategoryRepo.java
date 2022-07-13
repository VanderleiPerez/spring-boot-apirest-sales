package com.empresa.mitosales.repo;

import com.empresa.mitosales.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepo extends IGenericRepo<Category, Integer> {
}
