package com.voytenko.controllers;

import com.voytenko.dto.UserDto;
import com.voytenko.services.AccountsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/banned")
public class AdminController {

    private final AccountsService accountsService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getFinePage() {
        return ResponseEntity.ok().body(accountsService.getAllAccounts());
    }

    @PostMapping()
    public void setUserBan(@RequestBody UserDto user) {
        accountsService.setUserBan(user.getId());
    }

    @PostMapping("/remove")
    public void removeUserBan(@RequestBody UserDto user) {
        accountsService.removeBan(user.getId());
    }
}
