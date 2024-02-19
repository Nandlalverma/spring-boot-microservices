package com.ratingService.service;

import java.util.List;
import java.util.Optional;

import com.ratingService.entity.Rating;

public interface RatingService {


    Rating createRating(Rating rating);
    List<Rating> getAllRating();
    Optional<Rating> getRatingById(String ratingId);
    List<Rating> getRatingByUserId(String userId);
    List<Rating> getRatingByHotelId(String hotelId);
}
