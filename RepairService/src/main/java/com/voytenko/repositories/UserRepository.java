package com.voytenko.repositories;

import com.voytenko.models.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends UserBaseRepository<User> {
}
