package com.backend.hrportal.repository;

import java.util.Optional;

import com.backend.hrportal.models.ERole;
import com.backend.hrportal.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
