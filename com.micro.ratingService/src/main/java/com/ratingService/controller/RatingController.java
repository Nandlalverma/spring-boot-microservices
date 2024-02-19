package com.ratingService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ratingService.entity.Rating;
import com.ratingService.service.RatingService;

@RestController
@RequestMapping("/api/rating")
public class RatingController {

	@Autowired
	public RatingService ratingService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        Rating rating1 = ratingService.createRating(rating);
        return  new ResponseEntity<>(rating1,HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Rating>> getAllRating(){
        List<Rating> allRating = ratingService.getAllRating();
        return ResponseEntity.ok(allRating);
    }

    @GetMapping("/ratingId/{ratingId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Rating> getRatingById(@PathVariable String ratingId){
        Optional<Rating> ratingById = ratingService.getRatingById(ratingId);
        return ResponseEntity.of(ratingById);
    }

    @GetMapping("/userId/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable  String userId){
        List<Rating> ratingByUserId = ratingService.getRatingByUserId(userId);
        return ResponseEntity.ok(ratingByUserId);
    }

    @GetMapping("/hotelId/{hotelId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
        List<Rating> ratingByHotelId = ratingService.getRatingByHotelId(hotelId);
        return ResponseEntity.ok(ratingByHotelId);
    }

}
