package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.MoviecruiserApplication;
import com.cognizant.moviecruiser.exception.FavoritesEmptyException;
import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movie;

@Service
public class FavoritesDaoCollectionImpl implements FavoritesDao {

	@Autowired
	private MovieDaoCollectionImpl moiveDaoCollectionImpl;

	private static final Logger LOGGER = LoggerFactory.getLogger(MoviecruiserApplication.class);
	private static HashMap<String, Favorites> userFavorites;

	public FavoritesDaoCollectionImpl() {
		super();
		if(userFavorites==null)
		{
			userFavorites = new HashMap<String,Favorites>();
		}
	}

	@Override
	public void addFavoritesMovie(String userId, int movieId) {

		LOGGER.info("CartDaoImpl addFavoritesMovie() START");
		Movie movie = moiveDaoCollectionImpl.findById(movieId);

		if (userFavorites.containsKey(userId)) {
			ArrayList<Movie> movieFavoritesList = userFavorites.get(userId).getFavoritesMovieList();
			movieFavoritesList.add(movie);
		} else {
			Favorites favorite = new Favorites(new ArrayList<Movie>(), userId);
			favorite.getFavoritesMovieList().add(movie);
			userFavorites.put(userId, favorite);
		}
		LOGGER.info("CartDaoImpl addFavoritesMovie() END");

	}

	@Override
	public ArrayList<Movie> getAllFavoritesMovies(String userId) {
		LOGGER.info("MovieDaoCollectionImpl.getAllFavoritesMovies START");

		if (userFavorites.containsKey(userId)) {
//			double total = 0.0;
			ArrayList<Movie> movieFavoritesList = userFavorites.get(userId).getFavoritesMovieList();
			if (movieFavoritesList.isEmpty()) {
				throw new FavoritesEmptyException();
			}
			return movieFavoritesList;
		}

		LOGGER.info("MovieDaoCollectionImpl getAllFavoritesMovies END");
		throw new FavoritesEmptyException();
	}

	@Override
	public void removeFavoritesMovie(String userId, int movieId) {
		LOGGER.info("MovieDaoCollectionImpl removeFavoritesMovie START");
		Movie movie = moiveDaoCollectionImpl.findById(movieId);

		if (userFavorites.containsKey(userId)) {
			ArrayList<Movie> movieFavoritesList = userFavorites.get(userId).getFavoritesMovieList();

			for (int i = 0; i < movieFavoritesList.size(); i++) {
				if (movieFavoritesList.get(i).getId() == movieId) {
					movieFavoritesList.remove(i);
				}
			}
		} else {
			throw new FavoritesEmptyException();
		}
		LOGGER.info("MovieDaoCollectionImpl removeFavoritesMovie END");

	}

}
