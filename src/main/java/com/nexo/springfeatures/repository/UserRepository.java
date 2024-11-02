package com.nexo.springfeatures.repository;

import com.nexo.springfeatures.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Override
    Optional<User> findById(Long id);
    Optional<List<User>> findByName(String name);
}