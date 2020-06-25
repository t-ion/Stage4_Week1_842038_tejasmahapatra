package com.cognizant.moviecruiser.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.MoviecruiserApplication;
import com.cognizant.moviecruiser.dao.MovieDaoCollectionImpl;
import com.cognizant.moviecruiser.model.Movie;

@Service
public class MovieService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MoviecruiserApplication.class);

	@Autowired
	private MovieDaoCollectionImpl movieDaoCollectionImpl;

	public ArrayList<Movie> getMovieListAdmin() {
		LOGGER.info("MovieService ArrayList<Movie> getMovieListAdmin() START");

		LOGGER.info("MovieService ArrayList<Movie> getMovieListAdmin() END");
		return movieDaoCollectionImpl.getMovieListAdmin();
	}

	public ArrayList<Movie> getMovieListCustomer() {
		LOGGER.info("MovieService ArrayList<Movie> getMovieListAdmin() START");

		LOGGER.info("MovieService ArrayList<Movie> getMovieListAdmin() END");
		return movieDaoCollectionImpl.getMovieListCustomer();
	}

	public void modifyMovie(Movie movie) {
		LOGGER.info("MovieService modifyMovie(Movie movie) START");

		movieDaoCollectionImpl.modifyMovie(movie);
		LOGGER.info("MovieService modifyMovie(Movie movie) END");
	}
	
	public ArrayList<Movie> getMovieListActive()
	{
		LOGGER.info("MovieService ArrayList<Movie> getMovieListActive() START");

		
		
		LOGGER.info("MovieService ArrayList<Movie> getMovieListActive() END");

		return movieDaoCollectionImpl.getMovieListActive();
	}
}