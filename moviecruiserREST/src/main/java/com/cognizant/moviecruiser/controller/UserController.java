package com.cognizant.moviecruiser.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.MoviecruiserApplication;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.FavoritesService;
import com.cognizant.moviecruiser.service.MovieService;

@RestController
@RequestMapping("/movies")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MoviecruiserApplication.class);

	@Autowired
	private MovieService movieService;
	@Autowired
	private FavoritesService favoritesService;

	@GetMapping("/adminlist")
	public ArrayList<Movie> getMovieListAdmin() {
		LOGGER.info("MovieController getMovieListAdmin() START");

		LOGGER.info("MovieController getMovieListAdmin() END");
		return movieService.getMovieListAdmin();
	}

	@GetMapping("/userlist")
	public ArrayList<Movie> getMovieListCustomer() {
		LOGGER.info("MovieController ArrayList<Movie> getMovieListAdmin() START");

		LOGGER.info("MovieController ArrayList<Movie> getMovieListAdmin() END");
		return movieService.getMovieListCustomer();
	}
//update movie
	@PutMapping("/adminmodify")
	public void modifyMovie(@RequestBody Movie movie) {
		LOGGER.info("MovieController modifyMovie START");

		movieService.modifyMovie(movie);

		LOGGER.info("MovieController modifyMovie END");
	}
//favorites mapping
	
	@GetMapping("/favorites/{userId}")
	public ArrayList<Movie> getAllFavoritesMovies(@PathVariable @Valid String userId) {
		LOGGER.info("MovieController.getAllFavoritesMovies START");

		LOGGER.info("MovieController.getAllFavoritesMovies END");
		return favoritesService.getAllFavoritesMovies(userId);
	}

	
	@PostMapping("/{userId}/{movieId}")
	public void addFavoritesMovie(@PathVariable @Valid String userId, @PathVariable @Valid int movieId) {
		LOGGER.info("MovieController.addFavoritesMovie START");
		favoritesService.addFavoritesMovie(userId, movieId);
		LOGGER.info("MovieController.addFavoritesMovie END");

	}
	
	@DeleteMapping("/{userId}/{movieId}")
	public void removeFavoritesMovie(@PathVariable @Valid String userId, @PathVariable @Valid int movieId) {
		LOGGER.info("MovieController.removeFavoritesMovie START");
		favoritesService.removeFavoritesMovie(userId, movieId);
		LOGGER.info("MovieController.removeFavoritesMovie END");

	}
//get active movies
	@GetMapping("/active")
	public ArrayList<Movie> getMovieListActive() {
		LOGGER.info("MovieController.getMovieListActive() START");

		LOGGER.info("MovieController.getMovieListActive() END");
		return movieService.getMovieListActive();
	}

}