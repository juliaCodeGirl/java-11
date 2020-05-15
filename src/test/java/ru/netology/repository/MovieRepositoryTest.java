package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;
import ru.netology.manager.AfishaManager;

import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryTest {
    MovieRepository repository = new MovieRepository();
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
    void shouldSave() {
        MovieItem[] expected = new MovieItem[]{first};

        repository.save(first);

        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void shouldSaveAllMovies() {
        MovieItem[] expected = new MovieItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};

        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(eighth);
        repository.save(ninth);
        repository.save(tenth);
        repository.save(eleventh);

        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void shouldFindById() {
        MovieItem expected = new MovieItem(7, 7, "Номер один", "комедия", "http://image.com");

        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(eighth);
        repository.save(ninth);
        repository.save(tenth);
        repository.save(eleventh);

        MovieItem actual = repository.findById(7);

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnNullIfNotFindById() {
        MovieItem expected = repository.findById(14);

        assertNull(expected);
    }

    @Test
    void shouldRemoveById() {
        MovieItem[] expected = new MovieItem[]{first, second, third, fourth, fifth, seventh, eighth, ninth, tenth, eleventh};

        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(eighth);
        repository.save(ninth);
        repository.save(tenth);
        repository.save(eleventh);

        repository.removeById(6);


        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void shouldRemoveAll() {
        repository.removeAll();

        MovieItem[] expected = new MovieItem[0];

        assertArrayEquals(expected, repository.findAll());
    }
}