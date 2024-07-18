package com.workshopGruop.Workshop.resources;


import com.workshopGruop.Workshop.domain.Entities.Post;
import com.workshopGruop.Workshop.domain.Entities.User;
import com.workshopGruop.Workshop.dto.UserDTO;
import com.workshopGruop.Workshop.resources.util.URL;
import com.workshopGruop.Workshop.services.PostService;
import com.workshopGruop.Workshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
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

    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text",defaultValue = "") String text){
        text= URL.decodeParam(text);
        List<Post> list = postService.findByTitle(text);
        return ResponseEntity.ok().body(list);

    }

    @GetMapping("/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text",defaultValue = "")String text,
            @RequestParam(value ="minDate",defaultValue = "") String minDate,
            @RequestParam(value ="maxDate",defaultValue = "") String maxDate
    ){
        text= URL.decodeParam(text);
        Date min = URL.convertDate(minDate,new Date(0L));
        Date max = URL.convertDate(maxDate ,new Date());
        List<Post> list = postService.fullSeach(text,min,max);
        return ResponseEntity.ok().body(list);
    }

}
