package com.example.confiserie.service.impl;

import com.example.confiserie.model.dtos.CategoryViewDto;
import com.example.confiserie.model.dtos.ProductViewDto;
import com.example.confiserie.model.entity.Category;
import com.example.confiserie.model.enums.CategoryEnum;
import com.example.confiserie.repository.CategoryRepository;
import com.example.confiserie.service.CategoryService;
import com.example.confiserie.service.exeption.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper mapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
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

    @Override
    public Category findByCategoryNameEnum(CategoryEnum categoryEnum) {
        return categoryRepository.findByName(categoryEnum)
                .orElseThrow(() -> new ObjectNotFoundException("Category does not exist"));
    }

    @Override
    public List<CategoryViewDto> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(category -> {
                    CategoryViewDto categoryViewDto = new CategoryViewDto();
                    categoryViewDto.setName(category.getName());
                    List<ProductViewDto> productViewDtoList = category.getProducts()
                            .stream()
                            .map(product -> mapper.map(product, ProductViewDto.class))
                            .collect(Collectors.toList());
                    categoryViewDto.setProducts(productViewDtoList);
                    return categoryViewDto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public CategoryViewDto findByNameJam(CategoryEnum categoryEnum) {
        return getCategoryViewDto(categoryEnum);
    }

    @Override
    public CategoryViewDto findByNameTruffle(CategoryEnum categoryEnum) {
        return getCategoryViewDto(categoryEnum);
    }

    @Override
    public CategoryViewDto findByNameCake(CategoryEnum categoryEnum) {
        return getCategoryViewDto(categoryEnum);
    }

    @Override
    public CategoryViewDto findByNameTart(CategoryEnum categoryEnum) {
        return getCategoryViewDto(categoryEnum);
    }

    @Override
    public CategoryViewDto findByNameMacarons(CategoryEnum categoryEnum) {
        return getCategoryViewDto(categoryEnum);
    }

    private CategoryViewDto getCategoryViewDto(CategoryEnum categoryEnum) {
        Category category = categoryRepository.findByName(categoryEnum)
                .orElseThrow(() -> new ObjectNotFoundException("Category does not exist"));
        CategoryViewDto categoryViewDto = new CategoryViewDto();
        if (category != null) {
            categoryViewDto.setName(category.getName());
            List<ProductViewDto> products = category.getProducts()
                    .stream()
                    .map(product -> mapper.map(product, ProductViewDto.class))
                    .collect(Collectors.toList());

            categoryViewDto.setProducts(products);
        }
        return categoryViewDto;
    }
}
