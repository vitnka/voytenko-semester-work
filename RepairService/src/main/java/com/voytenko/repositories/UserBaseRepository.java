package com.voytenko.repositories;

import com.voytenko.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface UserBaseRepository<T extends User>
        extends JpaRepository<T, Integer> {

    Optional<T> findUserById(Integer id);

    Optional<T> findByEmail(String email);

}