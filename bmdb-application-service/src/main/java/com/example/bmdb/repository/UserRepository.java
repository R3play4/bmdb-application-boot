package com.example.bmdb.repository;

import com.example.bmdb.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface UserRepository extends CrudRepository<User, String> {
}
