package com.example.demo.controller.Upload;

import com.example.demo.services.CloudinaryServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/api/upload")
@RequiredArgsConstructor
public class UploadController {

    private final CloudinaryServices cloudinaryServices;

    @PostMapping(
            value = "/cover",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public String uploadCover(@RequestParam("file") MultipartFile file) {
        return cloudinaryServices.uploadFile(file, "comic/covers");
    }

    @PostMapping(
            value = "/banner",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public String uploadBanner(@RequestParam("file") MultipartFile file) {
        return cloudinaryServices.uploadFile(file, "comic/banners");
    }

    @PostMapping(
            value = "/chapter",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public String uploadChapter(@RequestParam("file") MultipartFile file) {
        return cloudinaryServices.uploadFile(file, "comic/chapters");
    }
}