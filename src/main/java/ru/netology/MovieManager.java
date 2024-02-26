package ru.netology;

public class MovieManager {
    private Movie[] movies;
    private int limit;

    public MovieManager() {
        this.limit = 5;
        this.movies = new Movie[0];
    }

    public MovieManager(int limit) {
        this.limit = limit;
        this.movies = new Movie[0];
    }

    public void addMovie(Movie movie) {
        Movie[] newMovies = new Movie[movies.length + 1];
        System.arraycopy(movies, 0, newMovies, 0, movies.length);
        newMovies[movies.length] = movie;
        movies = newMovies;
    }

    public Movie[] findAll() {
        return movies;
    }

    public Movie[] findLast() {
        int resultSize = Math.min(limit, movies.length);
        Movie[] result = new Movie[resultSize];

        for (int i = 0; i < resultSize; i++) {
            result[i] = movies[movies.length - 1 - i];
        }

        return result;
    }

    public int getLimit() {
        return limit;
    }
}

