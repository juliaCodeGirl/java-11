package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;

import static org.junit.jupiter.api.Assertions.*;

class AfishaManagerTest {
    AfishaManager manager = new AfishaManager();
    MovieItem first = new MovieItem(1, 1, "Бладшот", "боевик", "http://image.com");
    MovieItem second = new MovieItem(2, 2, "Вперёд", "мультфильм", "http://image.com");
    MovieItem third = new MovieItem(3, 3, "Отель 'Белград'", "комедия", "http://image.com");
    MovieItem fourth = new MovieItem(4, 4, "Джентльмены", "боевик", "http://image.com");
    MovieItem fifth = new MovieItem(5, 5, "Человек-невидимка", "ужасы", "http://image.com");
    MovieItem sixth = new MovieItem(6, 6, "Тролли. Мировой тур", "мультфильм", "http://image.com");
    MovieItem seventh = new MovieItem(7, 7, "Номер один", "комедия", "http://image.com");
    MovieItem eighth = new MovieItem(8, 8, "Оно", "ужасы", "http://image.com");
    MovieItem ninth = new MovieItem(9, 9, "Соник в кино", "приключения", "http://image.com");
    MovieItem tenth = new MovieItem(10, 10, "Дюна", "научная фантастика", "http://image.com");
    MovieItem eleventh = new MovieItem(11, 11, "Лёд", "спорт", "http://image.com");

    @Test
    void shouldAdd() {
        MovieItem[] expected = new MovieItem[] {first};

        manager.add(first);


        assertArrayEquals(expected, manager.getMovies());
    }

    @Test
    void shouldReturnAllMoviesForDefault() {
        MovieItem[] expected = new MovieItem[] {tenth,ninth,eighth,seventh,sixth,fifth,fourth, third,second,first};
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);

        assertArrayEquals(expected, manager.getMovies());
    }

    @Test
    void shouldReturnMoviesWithMoviesToReturned() {
        AfishaManager manager = new AfishaManager(5);
        MovieItem[] expected = new MovieItem[] {fifth,fourth,third,second,first};
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        assertArrayEquals(expected, manager.getMovies());
    }

    @Test
    void shouldEmptyArrayMovies() {
        assertArrayEquals(new MovieItem[0], manager.getMovies());
    }
}