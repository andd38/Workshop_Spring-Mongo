package com.workshopGruop.Workshop.domain.repository;

import com.workshopGruop.Workshop.domain.Entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<User,Long> {

}
