package com.example.confiserie.service;

import com.example.confiserie.model.dtos.CategoryViewDto;
import com.example.confiserie.model.entity.Category;
import com.example.confiserie.model.enums.CategoryEnum;

import java.util.List;

public interface CategoryService {

    void categoryInit();

    Category findByCategoryNameEnum(CategoryEnum categoryEnum);

    List<CategoryViewDto> findAll();

    CategoryViewDto findByNameJam(CategoryEnum categoryEnum);

    CategoryViewDto findByNameTruffle(CategoryEnum categoryEnum);

    CategoryViewDto findByNameCake(CategoryEnum categoryEnum);

    CategoryViewDto findByNameTart(CategoryEnum categoryEnum);

    CategoryViewDto findByNameMacarons(CategoryEnum categoryEnum);
}
