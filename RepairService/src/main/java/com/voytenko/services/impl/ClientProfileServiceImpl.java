package com.voytenko.services.impl;

import com.voytenko.dto.AccountProfileDto;
import com.voytenko.repositories.ClientRepository;
import com.voytenko.services.ClientProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientProfileServiceImpl implements ClientProfileService {

    private final ClientRepository clientRepository;

    @Override
    public AccountProfileDto getById(Integer id) {
        return AccountProfileDto.from(clientRepository.getById(id));
    }
}
