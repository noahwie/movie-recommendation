package com.example.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@CrossOrigin(origins = "https://noahwie.github.io/movie-recommendation")
@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/recommendation")
    public Movie getRecommendation() {
        List<Movie> movies = movieRepository.findAll();
        if (movies.isEmpty()) {
            throw new RuntimeException("No movies available!");
        }
        return movies.get(new Random().nextInt(movies.size()));
    }
}
