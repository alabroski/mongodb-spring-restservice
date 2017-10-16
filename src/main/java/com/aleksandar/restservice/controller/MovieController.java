package com.aleksandar.restservice.controller;

import com.aleksandar.restservice.data.model.Movie;
import com.aleksandar.restservice.data.repository.MovieRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * A rest controller exposing the endpoints of the service.
 */
@RestController
public class MovieController {

  private MovieRepository movieRepository;

  @Autowired
  public MovieController(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  /**
   * Movie search endpoint.
   *
   * @param movieName the movie name from the request parameters.
   * @param year the movie release year.
   *
   * @return a list of movies matched.
   */
  @RequestMapping(value = "/movieSearch", method = RequestMethod.POST)
  public List<Movie> movieSearch(@RequestParam(required = false) String movieName,
                                 @RequestParam(required = false) Integer year) {

    if (ObjectUtils.allNotNull(movieName, year)) {
      return movieRepository.findByNameContainingIgnoreCaseAndYear(movieName, year);
    } else if (StringUtils.isNotBlank(movieName)) {
      return movieRepository.findByNameContainingIgnoreCase(movieName);
    } else if (ObjectUtils.allNotNull(year)) {
      return movieRepository.findByYear(year);
    } else {
      return null;
    }
  }

  /**
   * New movie creation endpoint.
   *
   * @param movieName the name of the movie to be created.
   * @param movieDescription the description of the movie.
   * @param year the year of the movie's release.
   *
   * @return a success message if successful, exception message otherwise.
   */
  @RequestMapping(value = "/addMovie", method = RequestMethod.POST)
  public String addMovie(@RequestParam String movieName,
                         @RequestParam String movieDescription,
                         @RequestParam Integer year) {

    try {
      movieRepository.save(new Movie(movieName, movieDescription, year));
    } catch (RuntimeException exception) {
      return "Failed due to: " + exception.getMessage();
    }
    return "Success!";
  }

}
