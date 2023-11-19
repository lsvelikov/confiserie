package com.example.confiserie.service;

import com.example.confiserie.model.serviceModel.PictureServiceModel;

import java.io.IOException;

public interface PictureService {
    void addPicture(PictureServiceModel pictureServiceModel) throws IOException;
}
