package com.example.confiserie.service.impl;

import com.cloudinary.Cloudinary;
import com.example.confiserie.service.CloudinaryService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

@Service
public class CloudinaryServiceImpl implements CloudinaryService {

    private static final String TMP_FILE = "tmp";
    private static final String URL = "url";
    private final Cloudinary cloudinary;

    public CloudinaryServiceImpl(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Override
    public String uploadImage(MultipartFile multipartFile) throws IOException {
        File temporaryFile = File.createTempFile(TMP_FILE, multipartFile.getOriginalFilename());
        multipartFile.transferTo(temporaryFile);

        return cloudinary
                .uploader()
                .upload(temporaryFile, Collections.emptyMap())
                .get(URL)
                .toString();
    }
}
