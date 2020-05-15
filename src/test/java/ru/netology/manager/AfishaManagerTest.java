package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.MovieItem;
import ru.netology.repository.MovieRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class AfishaManagerTest {
    @Mock
    MovieRepository repository;

    @InjectMocks
    AfishaManager manager;
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
        doReturn(new MovieItem[] {first}).when(repository).findAll();
        doNothing().when(repository).save(first);

        MovieItem[] expected = new MovieItem[] {first};

        manager.add(first);


        assertArrayEquals(expected, manager.getMovies());
    }

    @Test
    void shouldReturnAllMoviesForDefault() {
        doReturn(new MovieItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth}).when(repository).findAll();

        MovieItem[] expected = new MovieItem[] {tenth,ninth,eighth,seventh,sixth,fifth,fourth, third,second, first};

        assertArrayEquals(expected, manager.getMovies());
    }

    @Test
    void shouldReturnMoviesWithMoviesToReturned() {
        MovieItem[] moviesToReturn = {first, second, third, fourth, fifth};
        doReturn(moviesToReturn).when(repository).findAll();
        MovieItem[] expected = new MovieItem[] {fifth,fourth,third,second,first};

        assertArrayEquals(expected, manager.getMovies());
    }

}