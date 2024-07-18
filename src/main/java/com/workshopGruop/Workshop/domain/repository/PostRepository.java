package com.workshopGruop.Workshop.domain.repository;

import com.workshopGruop.Workshop.domain.Entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post>findByTitleContainingIgnoreCase(String text);


}
