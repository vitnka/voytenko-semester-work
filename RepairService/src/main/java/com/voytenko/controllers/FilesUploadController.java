package com.voytenko.controllers;

import com.voytenko.models.User;
import com.voytenko.security.details.UserDetailsImpl;
import com.voytenko.services.FilesService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
@RequestMapping("/upload")
public class FilesUploadController {

    private final FilesService filesService;

    @PostMapping
    public String uploadFile(@RequestParam("file") MultipartFile multipart, Authentication authentication) {
        User user = ((UserDetailsImpl) authentication.getPrincipal()).getUser();

        filesService.upload(user.getId(), multipart);

        return "redirect:/profile";
    }
}
