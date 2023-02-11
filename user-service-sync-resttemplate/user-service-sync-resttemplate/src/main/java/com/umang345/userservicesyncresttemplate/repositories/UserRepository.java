package com.umang345.userservicesyncresttemplate.repositories;

import com.umang345.userservicesyncresttemplate.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
