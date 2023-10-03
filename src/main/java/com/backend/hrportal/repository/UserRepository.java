package com.backend.hrportal.repository;

import java.util.List;
import java.util.Optional;

import com.backend.hrportal.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);
  Optional<User> findByEmail(String email);
  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);

  List<User> findByUsernameContaining(String key);

  Optional<User> findByToken(String token);

}
