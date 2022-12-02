package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class movieRepository {
    private HashMap<String,movie>movieMap;
    private HashMap<String,director> directorMap;
    private HashMap<String, List<String>>directorMovieMap;

    public movieRepository() {
        this.movieMap=new HashMap<String,movie>();
        this.directorMap=new HashMap<String,director>();
        this.directorMovieMap=new HashMap<String,List<String>>();
    }
    public void saveMovie(movie movie){
        movieMap.put(movie.getName(),movie);
    }
    public void saveDirector(director director){
        directorMap.put(director.getName(),director);
    }

    public void saveMovieDirectorPair(String movie, String director) {
        if(movieMap.containsKey(movie) && directorMap.containsKey(director)){
            movieMap.put(movie, movieMap.get(movie));
            directorMap.put(director, directorMap.get(director));
            List<String> currentMovies = new ArrayList<String>();
            if(directorMovieMap.containsKey(director)) currentMovies = directorMovieMap.get(director);
            currentMovies.add(movie);
            directorMovieMap.put(director, currentMovies);
        }
    }
    public movie findMovie(String movie){
        return movieMap.get(movie);
    }

    public director findDirector(String director){
        return directorMap.get(director);
    }

    public List<String> findMoviesFromDirector(String director){
        List<String> moviesList = new ArrayList<String>();
        if(directorMovieMap.containsKey(director)) moviesList = directorMovieMap.get(director);
        return moviesList;
    }
    public List<String> findAllMovies(){
        return new ArrayList<>(movieMap.keySet());
    }
    public void deleteDirector(String director){
        List<String> movies = new ArrayList<String>();
        if(directorMovieMap.containsKey(director)){
            movies = directorMovieMap.get(director);
            for(String movie: movies){
                if(movieMap.containsKey(movie)){
                    movieMap.remove(movie);
                }
            }

            directorMovieMap.remove(director);
        }

        if(directorMap.containsKey(director)){
            directorMap.remove(director);
        }
    }
    public void deleteAllDirector(){
        HashSet<String> moviesSet = new HashSet<String>();

        //directorMap = new HashMap<>();

        for(String director: directorMovieMap.keySet()){
            for(String movie: directorMovieMap.get(director)){
                moviesSet.add(movie);
            }
        }

        for(String movie: moviesSet){
            if(movieMap.containsKey(movie)){
                movieMap.remove(movie);
            }
        }
    }
}
