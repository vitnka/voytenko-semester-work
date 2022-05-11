package com.voytenko.repositories;

import com.voytenko.models.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends UserBaseRepository<Client>  {
}
