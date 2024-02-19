package com.userService.external.sevice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.userService.entity.Rating;

@Service
@FeignClient(name = "RATING-SERVICE")
public interface RatingService {
	
	@GetMapping("/api/rating/{ratingId}")
	Rating getRatingById(@PathVariable("ratingId") String ratingId);

}
