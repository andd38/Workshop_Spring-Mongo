package com.workshopGruop.Workshop.domain.repository;

import com.workshopGruop.Workshop.domain.Entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
