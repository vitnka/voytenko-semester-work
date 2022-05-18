package com.voytenko.repositories;


import com.voytenko.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> getByConfirmCode(String conformCode);
    Optional<User> findByEmail(String email);

    List<User> findAllByRole(User.Role role);
}
