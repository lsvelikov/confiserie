package com.example.confiserie.service.impl;

import com.example.confiserie.model.entity.Category;
import com.example.confiserie.model.enums.CategoryEnum;
import com.example.confiserie.repository.CategoryRepository;
import com.example.confiserie.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void categoryInit() {

        if (categoryRepository.count() == 0) {

            Arrays.stream(CategoryEnum.values())
                    .forEach(c -> {
                        Category category = new Category();
                        category.setName(c);
                        category.setDescription(c.getValue());

                        categoryRepository.save(category);
                    });
        }
    }
}
