package com.workshopGruop.Workshop.resources;


import com.workshopGruop.Workshop.domain.Entities.User;

import com.workshopGruop.Workshop.dto.UserDTO;
import com.workshopGruop.Workshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserResources {

    @Autowired
    private UserService userService;

   @GetMapping
    public ResponseEntity<List<UserDTO>>findAll(){
        List<User> list = userService.findAll();

        List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }


}
