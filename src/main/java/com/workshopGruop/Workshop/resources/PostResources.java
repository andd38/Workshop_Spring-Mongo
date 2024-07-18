package com.workshopGruop.Workshop.resources;


import com.workshopGruop.Workshop.domain.Entities.Post;
import com.workshopGruop.Workshop.domain.Entities.User;
import com.workshopGruop.Workshop.dto.UserDTO;
import com.workshopGruop.Workshop.services.PostService;
import com.workshopGruop.Workshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/posts")
public class PostResources {

    @Autowired
    private PostService postService;

     @GetMapping("/{id}")
    public ResponseEntity<Post>findById(@PathVariable String id){
       Post obj = postService.findById(id);
       return ResponseEntity.ok().body(obj);
    }



}