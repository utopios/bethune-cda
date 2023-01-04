package com.example.coursspring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
@RequestMapping("upload")

public class UploadController {

    private String location = "upload-dir";

    @GetMapping("form")
    public ModelAndView form() {
        ModelAndView vm = new ModelAndView("form-upload");
        return vm;
    }

    @PostMapping("submitForm")
    @ResponseBody
    public void submitForm(@RequestParam("image") MultipartFile image) throws IOException {
        Path destinationFile = Paths.get(location).resolve(Paths.get(image.getOriginalFilename())).toAbsolutePath();
        InputStream stream = image.getInputStream();
        Files.copy(stream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
    }
}
