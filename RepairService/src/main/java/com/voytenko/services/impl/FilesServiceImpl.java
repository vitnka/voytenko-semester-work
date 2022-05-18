package com.voytenko.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.voytenko.models.Client;
import com.voytenko.repositories.ClientRepository;
import com.voytenko.services.FilesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class FilesServiceImpl implements FilesService {

    private final Cloudinary cloudinary;
    private final ClientRepository clientRepository;

    public void upload( Integer userId, MultipartFile multipart) {
        try {
            String url = cloudinary.uploader().upload(multipart.getBytes(),
                    ObjectUtils.asMap("public_id", userId + "_avatar")).get("url").toString();

            Client client = clientRepository.getById(userId);
            client.setProfileImg(url);

            clientRepository.save(client);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
