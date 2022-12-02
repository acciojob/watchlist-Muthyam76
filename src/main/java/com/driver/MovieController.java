package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {
    @Autowired
    MovieService movieServices;

    @PostMapping("/add-movie")
    public ResponseEntity<String>addMovie(@RequestBody Movie movie){
        movieServices.addMovie(movie);
        return new ResponseEntity<>("new movie added successfully", HttpStatus.CREATED);

    }
    @PostMapping("/add-director")
    public ResponseEntity<String>addDirector(@RequestBody Director director){
        movieServices.addDirector(director);
        return new ResponseEntity<>("new director added successfully", HttpStatus.CREATED);

    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String>addMovieDirectorPair(@RequestParam String movie,@RequestParam String director){
        movieServices.createMovieDirectorPair(movie,director);
        return new ResponseEntity<>("new movie-director pair added successfully", HttpStatus.CREATED);

    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        Movie movies = movieServices.findMovie(name);
        return new ResponseEntity<>(movies, HttpStatus.CREATED);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        Director directors = movieServices.findDirector(name);
        return new ResponseEntity<>(directors, HttpStatus.CREATED);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
        List<String> movies = movieServices.findMoviesFromDirector(director);
        return new ResponseEntity<>(movies, HttpStatus.CREATED);
    }
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> movies = movieServices.findAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String director){
        movieServices.deleteDirector(director);
        return new ResponseEntity<>(director + " removed successfully", HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieServices.deleteAllDirectors();
        return new ResponseEntity<>("All directors deleted successfully", HttpStatus.CREATED);
    }

    }



