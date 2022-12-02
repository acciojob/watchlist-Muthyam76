package com.driver;

public class director {
    private String name;
    private int numberOfMovies;
    private double imbdRating;

    public director() {
    }

    public director(String name,int numberOfMovies,double imbdRating) {
        this.name = name;
        this.numberOfMovies=numberOfMovies;
        this.imbdRating=imbdRating;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfMovies() {
        return numberOfMovies;
    }

    public double getImbdRating() {
        return imbdRating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfMovies(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }

    public void setImbdRating(double imbdRating) {
        this.imbdRating = imbdRating;
    }

}
