package com.example.SpringEsercizio8.Controllers;

import com.example.SpringEsercizio8.Entities.Car;
import com.example.SpringEsercizio8.Repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/car")
public class CarController {

    @Autowired
    private CarRepository carRepository;


    @PostMapping(path = "/create")
    public Car createCar(@RequestBody Car auto) {
        Car carSaved = carRepository.saveAndFlush(auto);
        return carSaved;
    }

    @GetMapping(path = "/read/{id}")
    public Car readCar(@PathVariable long id) {
        Car auto = null;
        if (!carRepository.existsById(id)) {
            return auto;
        } else {
            return carRepository.getById(id);
        }
    }
    @GetMapping(path = "/readAllCars")
    public List<Car> readCars (){
        return carRepository.findAll();
    }

    @PatchMapping(path = "/update/{id}")
    public Car updateCar(@PathVariable long id, @RequestBody Car car) {
        Car carNull = null;
        if (!carRepository.existsById(id)) {
            return carNull;
        } else {
            return carRepository.saveAndFlush(car);
        }
    }

    @DeleteMapping(path = "/deleteCar/{id}")
    public ResponseEntity<Car> deleteCar(@PathVariable long id) {
        boolean exist = carRepository.existsById(id);
        if (exist) {
            carRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping(path = "/deleteAllCars")
    public void deleteAllCars() {
        carRepository.deleteAll();
    }


}
