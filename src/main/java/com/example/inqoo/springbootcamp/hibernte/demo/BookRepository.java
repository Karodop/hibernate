package com.example.inqoo.springbootcamp.hibernte.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findAllBooksByTitle (String title);

    List<Book> findBookByEditionDateBeforeAndCoverTypeAndPageCountLessThan
            (LocalDate editionDate, String CoverType, int pageCount);

    /*@Query("select b from Book b where b.editionDate")*/


}

