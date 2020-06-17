package com.example.bmdb.repository;

import com.example.bmdb.domain.Media;
import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaRepository extends CrudRepository<Media, Integer> {
}
