package com.example.confiserie.service.impl;

import com.example.confiserie.model.entity.Picture;
import com.example.confiserie.model.serviceModel.PictureServiceModel;
import com.example.confiserie.repository.PictureRepository;
import com.example.confiserie.service.CloudinaryService;
import com.example.confiserie.service.PictureService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;
    private final ModelMapper mapper;
    private final CloudinaryService cloudinaryService;

    public PictureServiceImpl(PictureRepository pictureRepository, ModelMapper mapper, CloudinaryService cloudinaryService) {
        this.pictureRepository = pictureRepository;
        this.mapper = mapper;
        this.cloudinaryService = cloudinaryService;
    }

    @Override
    public void addPicture(PictureServiceModel pictureServiceModel) throws IOException {
        MultipartFile img = pictureServiceModel.getImg();
        String imageUrl = cloudinaryService.uploadImage(img);

        Picture picture = new Picture();
        picture.setTitle(pictureServiceModel.getTitle())
                .setImageUrl(imageUrl);

        pictureRepository.save(picture);
    }
}
