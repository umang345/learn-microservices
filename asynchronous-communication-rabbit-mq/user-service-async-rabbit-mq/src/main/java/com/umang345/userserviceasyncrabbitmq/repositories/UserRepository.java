package com.umang345.userserviceasyncrabbitmq.repositories;

import com.umang345.userserviceasyncrabbitmq.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
