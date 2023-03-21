package com.vtrack.vtrack.controller;

import com.vtrack.vtrack.model.Vehicle;
import com.vtrack.vtrack.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;
    @RequestMapping(path = "/addvehicle",
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<Vehicle> addVehicle(@RequestBody final Vehicle vehicle){
        Vehicle createdVehicle = vehicleService.addVehicle(vehicle);
        return ResponseEntity.ok(createdVehicle);
    }

    @RequestMapping(path = "/getVehicles/seats/{seatcount}",
            produces = "application/json")
    public ResponseEntity<List<Vehicle>> getVehiclesBySeatCount(@PathVariable("seatcount") Integer seatCount ){
        List<Vehicle> vehicles = vehicleService.getVehiclesBySeatCount(seatCount);
        return ResponseEntity.ok(vehicles);
    }



    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public List<String> handleVValidationExceptions(ConstraintViolationException ex) {
        List<String> errors = new ArrayList<>();
        ex.getConstraintViolations().forEach((error)->{
            errors.add(error.getMessage());

        });
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
        return errors;
    }


}
