package com.ratingService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ratingService.entity.Rating;

public interface RatingRepository  extends JpaRepository<Rating,String>{


    public Optional<Rating> findByRatingId(String ratingId);
    public Optional<Rating> findByUserId(String userId);
    public Optional<Rating> findByHotelId(String hotelId);
}
