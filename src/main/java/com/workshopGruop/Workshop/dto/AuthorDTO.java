package com.workshopGruop.Workshop.dto;

import com.workshopGruop.Workshop.domain.Entities.User;

public class AuthorDTO {
    private String id;
    private String name;

    public AuthorDTO(User obj) {
        id= obj.getId();
        name = obj.getName();
    }
    public AuthorDTO(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
