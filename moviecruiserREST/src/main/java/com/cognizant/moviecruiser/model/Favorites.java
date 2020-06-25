package com.cognizant.moviecruiser.model;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Favorites {

	private ArrayList<Movie> favoritesMovieList;
	private String us_id;
}
