package com.lawrenceorolobo.contactapi.webservice.repositories;

import com.lawrenceorolobo.contactapi.webservice.entities.User;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {


}
