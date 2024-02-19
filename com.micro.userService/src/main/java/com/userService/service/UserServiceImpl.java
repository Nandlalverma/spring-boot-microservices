package com.userService.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userService.entity.Hotel;
import com.userService.entity.Rating;
import com.userService.entity.User;
import com.userService.exception.ResourceNotFoundException;
import com.userService.external.sevice.HotelService;
import com.userService.external.sevice.RatingService;
import com.userService.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private RatingService ratingService;
	@Autowired
	private HotelService hotelService;
	@Autowired
    private UserRepository userRepository;
	@Autowired
	private RestTemplate resttemplate;
    @Override
    public User saveUser(User user) {
        String randomId = UUID.randomUUID().toString();
        user.setUserId(randomId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
	public User getUserById(String userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Id not found" + userId));
		// ArrayList forObject =
		// resttemplate.getForObject("http://localhost:8083/api/rating/userId/"+user.getUserId(),ArrayList.class);
		// user.setRating(forObject);
		Rating[] userRating = resttemplate.getForObject("http://RATING-SERVICE/api/rating/userId/" + user.getUserId(),Rating[].class);
       // Rating ratingById = ratingService.getRatingById(user.getUserId());
		//  List<Rating> ratings = Arrays.asList(ratingById);
		
		List<Rating> ratings = Arrays.stream(userRating).collect(Collectors.toList());
		ratings.stream().map(rating -> {
			ResponseEntity<Hotel> hotelRating = resttemplate.getForEntity("http://HOTEL-SERVICE/api/hotel/" + rating.getHotelId(), Hotel.class);
			Hotel hotel = hotelRating.getBody();
			//Hotel hotel = hotelService.getHotel(rating.getHotelId());  // this is the part of feignclient
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());
		user.setRating(ratings);

		return user;

	}
}
