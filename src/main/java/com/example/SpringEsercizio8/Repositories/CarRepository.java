package com.example.SpringEsercizio8.Repositories;

import com.example.SpringEsercizio8.Entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
