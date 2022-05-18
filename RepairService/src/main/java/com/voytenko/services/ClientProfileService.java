package com.voytenko.services;

import com.voytenko.dto.AccountProfileDto;

public interface ClientProfileService {

    AccountProfileDto getById(Integer id);
}
