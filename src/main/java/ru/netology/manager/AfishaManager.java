package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.MovieItem;
import ru.netology.repository.MovieRepository;

@NoArgsConstructor
@AllArgsConstructor
public class AfishaManager {
    private MovieRepository repository;
    private int moviesToReturnDefault = 10;
    private int moviesToReturn;


    public AfishaManager(MovieRepository repository, int moviesToReturn) {
        this.repository = repository;
        this.moviesToReturn = moviesToReturn;
    }

    public AfishaManager(MovieRepository repository) {
        this.repository = repository;
    }

    public void add(MovieItem movieItem) {
        repository.save(movieItem);
    }

    public MovieItem[] getMovies() {
        MovieItem[] moviesFromRepo = repository.findAll();
        int arrayLength = moviesFromRepo.length;

        if (moviesToReturn <= 0) {
            if (moviesToReturnDefault < moviesFromRepo.length) {
                arrayLength = moviesToReturnDefault;
            }
        } else {
            if (arrayLength < moviesFromRepo.length) {
                arrayLength = moviesToReturn;

            }
        }
        MovieItem[] result = new MovieItem[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            int index = moviesFromRepo.length - i - 1;
            result[i] = moviesFromRepo[index];
        }

        return result;
    }
}

