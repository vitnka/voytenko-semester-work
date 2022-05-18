package com.voytenko.services;

import com.voytenko.dto.UserDto;

import java.util.List;

public interface AccountsService {

    List<UserDto> getAllAccounts();

    void setUserBan(Integer id);

    void removeBan(Integer id);
}
