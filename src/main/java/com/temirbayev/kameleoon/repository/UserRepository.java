package com.temirbayev.kameleoon.repository;

import com.temirbayev.kameleoon.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<Users, Long> {
    List<Users> findByName(String name);

}
