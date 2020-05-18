package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.MovieItem;

@NoArgsConstructor
@AllArgsConstructor
public class AfishaManager {
    private MovieItem[] movies = new MovieItem[0];
    private int moviesToReturn;
    private int moviesToReturnDefault = 10;

    public AfishaManager(int moviesToReturn) {
        this.moviesToReturn = moviesToReturn;
    }

    public void add(MovieItem movieItem) {

        MovieItem[] tmp = new MovieItem[movies.length + 1];

        System.arraycopy(movies, 0, tmp, 0, movies.length);

        tmp[tmp.length - 1] = movieItem;

        movies = tmp;
    }

    public MovieItem[] getMovies() {
        int arrayLength = movies.length;

        if (moviesToReturn <= 0) {
            if (moviesToReturnDefault < movies.length) {
                arrayLength = moviesToReturnDefault;
            }
        } else {
            if (arrayLength < movies.length) {
                arrayLength = moviesToReturn;

            }
        }

        MovieItem[] result = new MovieItem[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }

        return result;
    }
}

