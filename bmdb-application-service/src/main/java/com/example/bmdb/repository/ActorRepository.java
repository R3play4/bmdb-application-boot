package com.example.bmdb.repository;

import com.example.bmdb.domain.Actor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Integer> {
}
