package com.workshopGruop.Workshop.resources;


import com.workshopGruop.Workshop.domain.Entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResources {

   @GetMapping
    public ResponseEntity< List<User>>findAll(){
        User maria = new User("1","maria silva ", "@mariasilvagamil.com");
        User alex = new User("2","alex hunter ", "alexHunter@21gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria,alex));
        return ResponseEntity.ok().body(list);

    }

}
