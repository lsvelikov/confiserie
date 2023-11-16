package com.example.confiserie.service;

import com.example.confiserie.model.entity.Category;
import com.example.confiserie.model.enums.CategoryEnum;

public interface CategoryService {

    void categoryInit();

    Category findByCategoryNameEnum(CategoryEnum categoryEnum);
}
