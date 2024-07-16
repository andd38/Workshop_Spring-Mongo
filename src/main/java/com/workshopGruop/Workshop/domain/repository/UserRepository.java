package com.workshopGruop.Workshop.domain.repository;

import com.workshopGruop.Workshop.domain.Entities.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends MongoRepository<User,String> {


}
