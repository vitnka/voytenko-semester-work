package com.voytenko.services;

import org.springframework.web.multipart.MultipartFile;

public interface FilesService {

    void upload(Integer userId, MultipartFile multipart);
}
