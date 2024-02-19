package com.ratingService.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratingService.entity.Rating;
import com.ratingService.exception.ResourceNotFoundException;
import com.ratingService.repository.RatingRepository;
@Service
public class RatingServiceImp implements RatingService{

    @Autowired
    private   RatingRepository ratingRepository;
    @Override
    public Rating createRating(Rating rating) {
        rating.setRatingId(UUID.randomUUID().toString());
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public Optional<Rating> getRatingById(String ratingId) {
        Optional<Rating> byRatingId = ratingRepository.findByRatingId(ratingId);
        if(byRatingId.isPresent()){
            return byRatingId;
        }else{
            throw new ResourceNotFoundException("Rating Id not found:"+ratingId);
        }
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        Optional<Rating> byUserId = ratingRepository.findByUserId(userId);
        if(byUserId.isPresent()){
            return List.of(byUserId.get());
        }else{
            throw new ResourceNotFoundException("UserId not found :"+userId);
        }
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        Optional<Rating> byHotelId = ratingRepository.findByHotelId(hotelId);
        if(byHotelId.isPresent()){
            return List.of(byHotelId.get());
        }else{
            throw  new ResourceNotFoundException("hotelId not found:"+hotelId);
        }

    }
}
