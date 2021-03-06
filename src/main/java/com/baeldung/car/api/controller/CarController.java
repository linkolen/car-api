package com.baeldung.car.api.controller;

import com.baeldung.car.api.model.Car;
import com.baeldung.car.api.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    @Autowired
    private CarRepository carRepository;

    @GetMapping
    public Iterable<Car> getCars() {
        return carRepository.findAll();
    }
    @GetMapping("/brand/{brand}")
    public Iterable<Car> getCarsByBrand(@PathVariable("brand") String brand) {
        return carRepository.findByBrand(brand);
    }
    @GetMapping("/model/{model}")
    public Iterable<Car> getCarsByModel(@PathVariable("model") String model) {
        return carRepository.findByModel(model);
    }
    @GetMapping("/color/{color}")
    public Iterable<Car> getCarsByColor(@PathVariable("color") String color) {
        return carRepository.findByColor(color);
    }
    @GetMapping("/fuel/{fuel}")
    public Iterable<Car> getCarsByFuel(@PathVariable("fuel") String fuel) {
        return carRepository.findByFuel(fuel);
    }
    @GetMapping("/year/{year}")
    public Iterable<Car> getCarsByYear(@PathVariable("year") int year) {
        return carRepository.findByYear(year);
    }

    @GetMapping("/{id}")
    public Optional<Car> getCarById(@PathVariable("id") String id) {
        return carRepository.findById(Long.parseLong(id));
    }

    @PostMapping
    public ResponseEntity<Car> addNewCar(@RequestBody Car car) {
        Car carEntity = carRepository.save(car);
        return new ResponseEntity<>(carEntity, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteCarById(@PathVariable("id") Long id) {
        carRepository.deleteById(id);
    }

}
