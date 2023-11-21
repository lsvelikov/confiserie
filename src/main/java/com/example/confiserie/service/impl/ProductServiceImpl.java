package com.example.confiserie.service.impl;

import com.example.confiserie.model.entity.Category;
import com.example.confiserie.model.entity.Product;
import com.example.confiserie.model.serviceModel.ProductServiceModel;
import com.example.confiserie.repository.ProductRepository;
import com.example.confiserie.service.CategoryService;
import com.example.confiserie.service.CloudinaryService;
import com.example.confiserie.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final CloudinaryService cloudinaryService;
    private final ModelMapper mapper;

    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService, CloudinaryService cloudinaryService, ModelMapper mapper) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.cloudinaryService = cloudinaryService;
        this.mapper = mapper;
    }

    @Override
    public void addProduct(ProductServiceModel productServiceModel) throws IOException {
        MultipartFile img = productServiceModel.getImg();
        String imageUrl = cloudinaryService.uploadImage(img);

        Product product = new Product();
                product.setName(productServiceModel.getName())
                .setImageUrl(imageUrl)
                .setQuantity(productServiceModel.getQuantity())
                .setPrice(productServiceModel.getPrice())
                .setDescription(productServiceModel.getDescription());
        Category category = categoryService.findByCategoryNameEnum(productServiceModel.getCategory());
                product.setCategory(category);

        productRepository.save(product);
    }

//    @Override
//    public List<ProductViewDto> findAll() {
//        return productRepository
//                .findAll()
//                .stream()
//                .map(product -> {
//                    ProductViewDto productViewDto = mapper.map(product, ProductViewDto.class);
//                    List<PictureViewDto> pictures = product
//                            .getPictures()
//                            .stream()
//                            .map(picture -> mapper.map(picture, PictureViewDto.class))
//                            .collect(Collectors.toList());
//
//                    productViewDto.setPictureViewDtoList(pictures);
//                    return productViewDto;
//                }).collect(Collectors.toList());
//    }
}
