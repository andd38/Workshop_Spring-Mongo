package com.workshopGruop.Workshop.resources;


import com.workshopGruop.Workshop.domain.Entities.User;

import com.workshopGruop.Workshop.dto.UserDTO;
import com.workshopGruop.Workshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
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
        List<UserDTO> listDTO = list.stream()
                .map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);

    }
     @GetMapping("/{id}")
    public ResponseEntity<UserDTO>findById(@PathVariable String id){
       User obj = userService.findById(id);
       return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO user){
       User obj = userService.fromDTO(user);
       obj = userService.saveUser(obj);
       URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(obj.getId())
               .toUri();
       return ResponseEntity.created(uri).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
