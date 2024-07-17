package com.workshopGruop.Workshop.services;

import com.workshopGruop.Workshop.domain.Entities.User;
import com.workshopGruop.Workshop.domain.repository.UserRepository;

import com.workshopGruop.Workshop.dto.UserDTO;
import com.workshopGruop.Workshop.services.exception.ObjectNotFoundException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User findById(String id){
        return repository.findById(id).orElseThrow(()-> new ObjectNotFoundException("user not found"));
    }

    public List<User> findAll(){
        return repository.findAll();
    }

    public User saveUser(User user){
        return repository.insert(user);
    }

    public void delete(String id){
        findById(id);
        repository.deleteById(id);

    }
    public User update(User user){
        User updateUser =  repository.findById(user.getId())
                .orElseThrow(()-> new ObjectNotFoundException("user not found"));
        updateData(updateUser,user);
        return repository.save(updateUser);
    }

    private void updateData(User updateUser, User user) {
        updateUser.setName(user.getName());
        updateUser.setEmail(user.getEmail());

    }

    //function aux
    public User fromDTO(UserDTO dto){
        return new User(dto.getId(), dto.getName(), dto.getEmail());
    }



}
