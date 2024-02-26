package com.wecp.repos;

import java.util.Optional;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wecp.entities.User;
 

 
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    User findByUserId(long userId);
    void deleteByUserId(long userId);
    Optional<User> findByEmail(String email);
}