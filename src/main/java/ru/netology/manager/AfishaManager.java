package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.MovieItem;
import ru.netology.repository.MovieRepository;

@NoArgsConstructor
@AllArgsConstructor
public class AfishaManager {
    private MovieRepository repository = new MovieRepository();
    private int moviesToReturn = 10;

    public AfishaManager(MovieRepository repository) {
        this.repository = repository;
    }

    public void add(MovieItem movieItem) {
        repository.save(movieItem);
    }

    public MovieItem[] getMovies() {
        MovieItem[] moviesFromRepo = repository.findAll();

        int arrayLength = moviesToReturn;
        if (moviesFromRepo.length < arrayLength) {
            arrayLength = moviesFromRepo.length;
        }
        MovieItem[] result = new MovieItem[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            int index = moviesFromRepo.length - i - 1;
            result[i] = moviesFromRepo[index];
        }

        return result;
    }
}

