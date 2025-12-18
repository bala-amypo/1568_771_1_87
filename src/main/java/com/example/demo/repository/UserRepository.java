package com.example.demo.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String email);

    User save(User user);

    Optional<User> findById(long id);

    List<User> findAll();
}