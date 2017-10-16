package com.aleksandar.restservice;

import com.aleksandar.restservice.data.model.Movie;
import com.aleksandar.restservice.data.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

/**
 * The spring boot application class.
 */
@SpringBootApplication
public class RestServiceApplication {

  @Autowired
  private MovieRepository movieRepository;

	public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
	}

  /**
   * Populates the DB with a couple of movies initially.
   */
	@PostConstruct
  public void init() {
    movieRepository.save(
            new Movie("The Game", "Movie description 1", 1997));
    movieRepository.save(
            new Movie("The Girl with the Dragon Tatoo", "Movie description 2", 2011));
    movieRepository.save(
            new Movie("Identity", "Movie description 3", 2003));
    movieRepository.save(
            new Movie("The Machinist", "Movie description 4", 2004));
    movieRepository.save(
            new Movie("The Illusionist", "Movie description 5", 2006));
    movieRepository.save(
            new Movie("Source Code", "Movie description 6", 2011));
    movieRepository.save(
            new Movie("The Butterfly Effect", "Movie description 7", 2004));
  }
}
