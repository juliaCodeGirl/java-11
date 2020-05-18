package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;

import static org.junit.jupiter.api.Assertions.*;

class AfishaManagerTest {
    AfishaManager manager = new AfishaManager();
    private MovieItem first = new MovieItem(1, 1, "Бладшот", "боевик", "http://image.com");
    private MovieItem second = new MovieItem(2, 2, "Вперёд", "мультфильм", "http://image.com");
    private MovieItem third = new MovieItem(3, 3, "Отель 'Белград'", "комедия", "http://image.com");
    private MovieItem fourth = new MovieItem(4, 4, "Джентльмены", "боевик", "http://image.com");
    private MovieItem fifth = new MovieItem(5, 5, "Человек-невидимка", "ужасы", "http://image.com");
    private MovieItem sixth = new MovieItem(6, 6, "Тролли. Мировой тур", "мультфильм", "http://image.com");
    private MovieItem seventh = new MovieItem(7, 7, "Номер один", "комедия", "http://image.com");
    private MovieItem eighth = new MovieItem(8, 8, "Оно", "ужасы", "http://image.com");
    private MovieItem ninth = new MovieItem(9, 9, "Соник в кино", "приключения", "http://image.com");
    private MovieItem tenth = new MovieItem(10, 10, "Дюна", "научная фантастика", "http://image.com");
    private MovieItem eleventh = new MovieItem(11, 11, "Лёд", "спорт", "http://image.com");

    //добавление фильма
    @Test
    void shouldAdd() {
        MovieItem[] expected = new MovieItem[]{first};

        manager.add(first);

        assertArrayEquals(expected, manager.getMovies());
    }

    //возвращение по умолчанию 10, даже если добавлено больше
    @Test
    void shouldReturnAllMoviesForDefault() {
        MovieItem[] expected = new MovieItem[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
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
        manager.add(eleventh);

        assertArrayEquals(expected, manager.getMovies());
    }

    //возвращение с указанным числом возврата (5)
    @Test
    void shouldReturnMoviesWithMoviesToReturned() {
        AfishaManager manager = new AfishaManager(5);
        MovieItem[] expected = new MovieItem[]{fifth, fourth, third, second, first};
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);

        assertArrayEquals(expected, manager.getMovies());
    }

    //вернуть пустой массив
    @Test
    void shouldEmptyArrayMovies() {
        assertArrayEquals(new MovieItem[0], manager.getMovies());
    }

    //возвращение последних 4 добавленнных фильмов, даже если указано вернуть 6
    @Test
    void shouldReturnLastFourIfMoviesToReturnSix() {
        AfishaManager manager = new AfishaManager(6);
        MovieItem[] expected = new MovieItem[]{fourth, third, second, first};
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        assertArrayEquals(expected, manager.getMovies());
    }

    //после добавления фильмов, вернуть пустой массив,т.к. указано вернуть 0
    @Test
    void shouldReturnEmptyArrayIfAddMoviesAndMoviesToReturnZero() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        AfishaManager manager = new AfishaManager(0);
        MovieItem[] expected = new MovieItem[0];

        assertArrayEquals(expected, manager.getMovies());
    }

    //возвращение фильмов по умолчанию (10), при запросе числа меньше 0
    @Test
    void shouldReturnDefaultIfLessZero() {
        manager = new AfishaManager(-4);
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
        MovieItem[] expected = new MovieItem[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, manager.getMovies());
    }
}