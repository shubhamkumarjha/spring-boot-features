package com.nexo.springfeatures.repository;

import com.nexo.springfeatures.dao.Movie;
import com.nexo.springfeatures.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
    @Override
    Optional<Movie> findById(Long id);
    Optional<List<Movie>> findByName(Long name);
}