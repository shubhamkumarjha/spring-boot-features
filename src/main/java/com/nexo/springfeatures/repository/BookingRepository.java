package com.nexo.springfeatures.repository;

import com.nexo.springfeatures.dao.Booking;
import com.nexo.springfeatures.dao.Movie;
import com.nexo.springfeatures.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
    @Override
    Optional<Booking> findById(Long id);
    Optional<List<Booking>> findByUserId(User user);
    Optional<List<Booking>> findByMovieId(Movie movie);
}