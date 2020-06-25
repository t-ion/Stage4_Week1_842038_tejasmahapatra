package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;

import com.cognizant.moviecruiser.exception.FavoritesEmptyException;
import com.cognizant.moviecruiser.model.Movie;

public interface FavoritesDao {

	public void addFavoritesMovie(String userId, int movieId);
	public ArrayList<Movie> getAllFavoritesMovies(String userId) throws FavoritesEmptyException;
	public void removeFavoritesMovie(String userId, int movieId);
}
