package com.example.inqoo.springbootcamp.hibernte.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class EntitiesTest {

    @Autowired
    CarRepository carRepository;
    @Autowired
    BookRepository bookRepository;

    @BeforeEach  // - przed kazdym testem wywoła sie ta metoda, zainicjuje baze danych
    void init () {
        carRepository.save(new Car("Renault","Twingo","fuel",120,3,"red"));
        carRepository.save(new Car("Renault","Master","diesel",130,2,"green"));
        carRepository.save(new Car("Audi","A7","fuel",160,5,"red"));

        bookRepository.save(new Book("ISBN33",1,"title3", LocalDate.of(2012,4,23),"paper",124));
        bookRepository.save(new Book("ISBN23",2,"title2", LocalDate.of(2022,1,07),"hard",342));
        bookRepository.save(new Book("ISBN13",3,"title4", LocalDate.of(2002,5,23),"paper",111));
    }

    @Test

    public void shouldfindAllCars(){

    List<Car> allCars = carRepository.findAll();
    assertThat(allCars.size()).isEqualTo(3);
    }

    @Test
    public void shouldFindOtherCars(){

    List <Car> all = carRepository.findAll();
    assertThat(all.size()).isEqualTo(3);
    }

    @Test

    public void shouldReturnBookPerTitle(){
    //given
    Optional<Book> booksPerTitle = bookRepository.findAllBooksByTitle("title2");
    assertThat(booksPerTitle.get().getCoverType()).isEqualTo("hard");

    }
    @Test
    public void shouldReturnCarByPowerBrandEngineType() {

        List<Car> carByPowerBrandEngineType = carRepository.findCarByEngineTypeAndPowerGreaterThanAndBrandNot("diesel", 100, "Audi");
        assertThat(carByPowerBrandEngineType.size()).isEqualTo(2);
    }

    @Test
    public void shouldReturnBookByTitleNamePageCover() {
        List<Book> booksByEditionCoverPageCount = bookRepository.findBookByEditionDateBeforeAndCoverTypeAndPageCountLessThan(LocalDate.of(1991, 5, 20), "paper", 101);
        assertThat(booksByEditionCoverPageCount.size()).isEqualTo(1);

}
    @Test

    public void shouldReturnCarByPowerBrandEngineType2(){

        List<Car> searchCarForDress = carRepository.searchCarForDress("diesel", 130,"Renault");
        assertThat(searchCarForDress.size()).isEqualTo(0);
}



}
