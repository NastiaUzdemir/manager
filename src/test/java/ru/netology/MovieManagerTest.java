package ru.netology;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MovieManagerTest {
    private MovieManager movieManager;

    @Before
    public void setUp() {
        movieManager = new MovieManager();
    }

    @Test
    public void testAddMovie() {
        // Создаем фильмы для теста
        Movie movie1 = new Movie("Фильм 1");
        Movie movie2 = new Movie("Фильм 2");
        Movie movie3 = new Movie("Фильм 3");

        // Добавляем фильмы в менеджер афиши
        movieManager.addMovie(movie1);
        movieManager.addMovie(movie2);
        movieManager.addMovie(movie3);

        // Проверяем, что фильмы успешно добавлены
        assertArrayEquals(new Movie[]{movie1, movie2, movie3}, movieManager.findAll());
    }

    @Test
    public void testFindAll() {
        Movie movie1 = new Movie("Фильм 1");
        Movie movie2 = new Movie("Фильм 2");
        Movie movie3 = new Movie("Фильм 3");

        movieManager.addMovie(movie1);
        movieManager.addMovie(movie2);
        movieManager.addMovie(movie3);

        Movie[] allMovies = movieManager.findAll();

        assertArrayEquals(new Movie[]{movie1, movie2, movie3}, allMovies);
    }

    @Test
    public void testFindLast() {
        Movie movie1 = new Movie("Фильм 1");
        Movie movie2 = new Movie("Фильм 2");
        Movie movie3 = new Movie("Фильм 3");

        movieManager.addMovie(movie1);
        movieManager.addMovie(movie2);
        movieManager.addMovie(movie3);

        Movie[] lastMovies = movieManager.findLast();

        assertArrayEquals(new Movie[]{movie3, movie2, movie1}, lastMovies);
    }

    @Test
    public void testConstructorWithLimit() {
        int limit = 3;

        MovieManager movieManager = new MovieManager(limit);

        // Проверка на установление ограничения
        Assert.assertEquals(limit, movieManager.getLimit());

        // Проверка, что при создании менеджера афиши не содержит фильмов
        assertArrayEquals(new Movie[0], movieManager.findAll());
    }

    @Test
    public void testFindLastWhenMoviesLessThanLimit() {
        MovieManager movieManager = new MovieManager(5);

        Movie movie1 = new Movie("Фильм 1");
        movieManager.addMovie(movie1);

        Movie[] result = movieManager.findLast();

        assertArrayEquals(new Movie[]{movie1}, result);
    }

    @Test
    public void testFindLastWhenMoviesMoreThanLimit() {
        MovieManager movieManager = new MovieManager(5);

        Movie movie1 = new Movie("Фильм 1");
        movieManager.addMovie(movie1);

        Movie movie2 = new Movie("Фильм 2");
        movieManager.addMovie(movie2);

        Movie movie3 = new Movie("Фильм 3");
        movieManager.addMovie(movie3);

        Movie movie4 = new Movie("Фильм 4");
        movieManager.addMovie(movie4);

        Movie movie5 = new Movie("Фильм 5");
        movieManager.addMovie(movie5);

        Movie movie6 = new Movie("Фильм 6");
        movieManager.addMovie(movie6);

        Movie[] result = movieManager.findLast();

        assertArrayEquals(new Movie[]{movie6, movie5, movie4, movie3, movie2}, result);
    }

    @Test
    public void testFindLastWhenMoviesEqualToLimit() {
        MovieManager movieManager = new MovieManager(3);

        Movie movie1 = new Movie("Фильм 1");
        movieManager.addMovie(movie1);

        Movie movie2 = new Movie("Фильм 2");
        movieManager.addMovie(movie2);

        Movie movie3 = new Movie("Фильм 3");
        movieManager.addMovie(movie3);

        Movie[] result = movieManager.findLast();

        assertArrayEquals(new Movie[]{movie3, movie2, movie1}, result);
    }
}