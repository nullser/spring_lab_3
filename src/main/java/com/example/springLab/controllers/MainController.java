package com.example.springLab.controllers;


import com.example.springLab.classes.ResultOfTriangle;
import com.example.springLab.classes.Triangle;
import com.example.springLab.service.TriangleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Min;

@Validated
@RestController
public class MainController {

    private TriangleService service;
    private final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    public MainController(TriangleService service) {
        this.service = service;
    }

    @GetMapping("/Triangle")
    public ResultOfTriangle getParameters(@RequestParam @Min(1) float sideFirst,
                                          @RequestParam @Min(1) float sideSecond,
                                          @RequestParam @Min(1) float sideThird) throws ConstraintViolationException, InterruptedException {

        return  service.calculate( new Triangle(sideFirst, sideSecond, sideThird));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {

        logger.warn(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}