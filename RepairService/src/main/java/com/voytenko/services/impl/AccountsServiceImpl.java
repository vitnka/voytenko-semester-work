package com.voytenko.services.impl;

import com.voytenko.dto.UserDto;
import com.voytenko.models.User;
import com.voytenko.repositories.UserRepository;
import com.voytenko.services.AccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements AccountsService {

    private final UserRepository userRepository;

    @Override
    public List<UserDto> getAllAccounts() {
        return UserDto.from(userRepository.findAllByRole(User.Role.USER));
    }

    @Override
    public void setUserBan(Integer id) {
        User user = userRepository.getById(id);
        user.setState(User.State.BANNED);
        userRepository.save(user);
    }

    @Override
    public void removeBan(Integer id) {
        User user = userRepository.getById(id);
        user.setState(User.State.CONFIRMED);
        userRepository.save(user);
    }
}
