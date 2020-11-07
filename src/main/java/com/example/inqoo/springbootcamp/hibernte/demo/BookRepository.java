package com.example.inqoo.springbootcamp.hibernte.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findAllBooksByTitle (String title);

}

