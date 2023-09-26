package dev.sachin96boy.employbend.repository;

import dev.sachin96boy.employbend.models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserModel, String> {
    Optional<UserModel> findByuserName(String userName);

    Boolean existsByuserName(String username);

    Boolean existsByuserEmail(String email);
}
