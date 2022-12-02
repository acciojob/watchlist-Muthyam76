package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class movieService {
    @Autowired
    movieRepository movieRepositorys;


    public void addMovie(movie movie) {
        movieRepositorys.saveMovie(movie);
    }

    public void addDirector(director director) {
        movieRepositorys.saveDirector(director);
    }

    public void createMovieDirectorPair(String movie, String director) {
        movieRepositorys.saveMovieDirectorPair(movie,director);

    }
    public movie findMovie(String movieName){
        return movieRepositorys.findMovie(movieName);
    }

    public director findDirector(String directorName){
        return movieRepositorys.findDirector(directorName);
    }

    public List<String> findMoviesFromDirector(String director){
        return movieRepositorys.findMoviesFromDirector(director);
    }
    public List<String> findAllMovies(){
        return movieRepositorys.findAllMovies();
    }
    public void deleteDirector(String director){
        movieRepositorys.deleteDirector(director);
    }

    public void deleteAllDirectors(){
        movieRepositorys.deleteAllDirector();
    }

}
