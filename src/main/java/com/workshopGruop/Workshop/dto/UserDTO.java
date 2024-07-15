package com.workshopGruop.Workshop.dto;

import com.workshopGruop.Workshop.domain.Entities.User;
import org.bson.types.ObjectId;

public class UserDTO {
    private ObjectId id;
    private String name;
    private String email;
    public UserDTO(User obj){
        id =obj.getId();
        name = obj.getName();
        email = obj.getEmail();
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
