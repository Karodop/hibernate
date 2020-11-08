package com.example.inqoo.springbootcamp.hibernte.demo;

import org.apache.catalina.Engine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {

    Optional<Car> findAllCarByModel (String model);
    List<Car> findCarByBrand (String brand);
    List<Car> findCarByEngineTypeAndPowerGreaterThanAndBrandNot (String engineType, int power, String brand);

    @Query("select c from Car c where c.engineType = ?1 and c.power > ?2 and c.brand not like ?3")
    List<Car> searchCarForDress (String engineType, int power, String brand);

    @Query("select c from Car c where c.brand = ?1")
    Optional<Car> searchCarByBrand (String brand);







}