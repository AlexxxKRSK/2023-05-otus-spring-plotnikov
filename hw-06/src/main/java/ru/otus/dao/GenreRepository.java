package ru.otus.dao;


import ru.otus.domain.Genre;

import java.util.Optional;

public interface GenreRepository {

    Genre saveGenre(Genre genre);

    Optional<Genre> getGenreByName(String name);

}