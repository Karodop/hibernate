package com.example.inqoo.springbootcamp.hibernte.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {

    Optional<Car> findAllCarByModel (String model);

}