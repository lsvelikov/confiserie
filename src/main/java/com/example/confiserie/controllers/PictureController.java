package com.example.confiserie.controllers;

import com.example.confiserie.model.serviceModel.PictureServiceModel;
import com.example.confiserie.service.PictureService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/pictures")
public class PictureController {

    private final PictureService pictureService;

    public PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @GetMapping("/add")
    public String add() {
        return "picture-add";
    }

    @PostMapping("/add")
    public String addPicture(@ModelAttribute("pictureServiceModel")
                             PictureServiceModel pictureServiceModel) throws IOException {

        pictureService.addPicture(pictureServiceModel);

        return "redirect:/";
    }
}
