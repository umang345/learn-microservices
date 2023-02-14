package com.umang345.userserviceasynccommunicationenableasync.repositories;

import com.umang345.userserviceasynccommunicationenableasync.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
