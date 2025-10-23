package com.vtrack.vtrack.controller;

import com.vtrack.vtrack.entity.Vehicle;
import com.vtrack.vtrack.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;
    @RequestMapping(path = "/add",
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<Vehicle> addVehicle(@RequestBody  @Valid final Vehicle vehicle){
        Vehicle createdVehicle = vehicleService.addVehicle(vehicle);
        return ResponseEntity.ok(createdVehicle);
    }

    @RequestMapping(path = "/get/seats/{seatcount}",
            produces = "application/json")
    public ResponseEntity<List<Vehicle>> getVehiclesBySeatCount(@PathVariable("seatcount") Integer seatCount ){
        List<Vehicle> vehicles = vehicleService.getVehiclesBySeatCount(seatCount);
        return ResponseEntity.ok(vehicles);
    }




//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(ConstraintViolationException.class)
//    public Map<String, String> handleVValidationExceptions(ConstraintViolationException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getConstraintViolations().forEach((error)->{
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getMessage();
//            errors.put(fieldName, errorMessage);
//
//        });
////        ex.getBindingResult().getAllErrors().forEach((error) -> {
////            String fieldName = ((FieldError) error).getField();
////            String errorMessage = error.getDefaultMessage();
////            errors.put(fieldName, errorMessage);
////        });
//        return errors;
//    }






}
