package ru.otus.repository;


import org.springframework.data.repository.CrudRepository;
import ru.otus.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    List<Author> findAll();

    Optional<Author> getAuthorByName(String name);

}