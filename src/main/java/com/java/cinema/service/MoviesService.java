package com.java.cinema.service;

import com.java.cinema.entity.Movie;
import com.java.cinema.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MoviesService {

    @Autowired
    private final MovieRepository movieRepository;

    public void saveMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public void deleteMovieById(Integer movieId) {
        movieRepository.deleteById(movieId);
    }

    public Optional<Movie> findMovieById(Integer movieId) {
        return movieRepository.findById(movieId);
    }

    public Movie findMovieByName(String movieName) {
        return movieRepository.findByName(movieName);
    }

    public List<Movie> findMoviesAll() {
        return movieRepository.findAll();
    }





}
