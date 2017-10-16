package com.aleksandar.restservice.data.repository;

import com.aleksandar.restservice.data.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Interface abstraction providing CRUD repository capabilities extending the MongoRepository interface.
 * Spring wraps this in a proxy and implements the specified queries by the user-specified keywords.
 */

public interface MovieRepository extends MongoRepository<Movie, String> {

  /**
   * Finds all movies that completely or partially match the string specified in {@param name}.
   * Case insensitive.
   *
   * @param name the name of the movie to be found.
   *
   * @return a list of movies matched.
   */
  List<Movie> findByNameContainingIgnoreCase(String name);

  /**
   * Finds all movies released in a certain year.
   *
   * @param year the year of the movie(s) release.
   *
   * @return a list of movies matched.
   */
  List<Movie> findByYear(Integer year);

  /**
   * Find all movies by name and by year.
   *
   * @param name the name of the movie.
   *
   * @param year the year of the movie(s) release.
   *
   * @return a list of movies matched.
   */
  List<Movie> findByNameContainingIgnoreCaseAndYear(String name, Integer year);
}
