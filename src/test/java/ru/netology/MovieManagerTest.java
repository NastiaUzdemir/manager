package ru.netology;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        Assert.assertArrayEquals(new Movie[]{movie1, movie2, movie3}, movieManager.findAll());
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

        Assert.assertArrayEquals(new Movie[]{movie1, movie2, movie3}, allMovies);
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

        Assert.assertArrayEquals(new Movie[]{movie3, movie2, movie1}, lastMovies);
    }

    @Test
    public void testConstructorWithLimit() {
        int limit = 3;

        MovieManager movieManager = new MovieManager(limit);

        // Проверка на установление ограничения
        Assert.assertEquals(limit, movieManager.getLimit());

        // Проверка, что при создании менеджера афиши не содержит фильмов
        Assert.assertArrayEquals(new Movie[0], movieManager.findAll());
    }
}