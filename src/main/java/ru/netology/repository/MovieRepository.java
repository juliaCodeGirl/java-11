package ru.netology.repository;

import ru.netology.domain.MovieItem;

public class MovieRepository {
    private MovieItem[] movies = new MovieItem[0];

    public void save(MovieItem movieItem) {

        MovieItem[] tmp = new MovieItem[movies.length + 1];

        System.arraycopy(movies, 0, tmp, 0, movies.length);
        tmp[tmp.length - 1] = movieItem;
        movies = tmp;
    }

    public MovieItem[] findAll() {
        return movies;
    }

    public MovieItem findById(int id) {
        for (MovieItem movieItem : movies) {
            if (movieItem.getId() == id) {
                return movieItem;
            }
        }
        return null;
    }

    public void removeById(int id) {
        MovieItem[] tmp = new MovieItem[movies.length - 1];
        int i = 0;
        for (MovieItem movieItem : movies) {
            if (movieItem.getId() != id) {
                tmp[i] = movieItem;
                i++;
            }
        }
        movies = tmp;
    }

    public void removeAll() {
        movies = new MovieItem[0];
    }

}
