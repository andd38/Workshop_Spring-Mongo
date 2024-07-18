package com.workshopGruop.Workshop.services;

import com.workshopGruop.Workshop.domain.Entities.Post;
import com.workshopGruop.Workshop.domain.repository.PostRepository;
import com.workshopGruop.Workshop.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id){
        return repository.findById(id).orElseThrow(()-> new ObjectNotFoundException("post not found"));
    }

    public List<Post> findByTitle(String text){
        return repository.findByTitleContainingIgnoreCase(text);
    }


}
