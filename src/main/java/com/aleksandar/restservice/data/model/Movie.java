package com.aleksandar.restservice.data.model;

import org.springframework.data.annotation.Id;

/**
 * Data model representing a single movie.
 */
public class Movie {

  @Id
  private String id;

  private String name;

  private String description;

  private Integer year;

  /**
   * Default constructor.
   */
  public Movie() {}

  /**
   * Constructor with 3 parameters.
   *
   * @param name the name of the movie.
   * @param description the description of the movie.
   * @param year the year of the movie's release.
   */
  public Movie(String name, String description, Integer year) {
    this.name = name;
    this.description = description;
    this.year = year;
  }

  @Override
  public String toString() {
    return String.format(
            "Movie[id=%s, name='%s', description='%s', year='%s']", id, name, description, year);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }
}
