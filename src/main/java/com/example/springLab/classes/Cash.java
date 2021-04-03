package com.example.springLab.classes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Cash {

    private final Map<Triangle, ResultOfTriangle> cash = new HashMap<>();

    public ResultOfTriangle addRectangleToCash(Triangle triangle, ResultOfTriangle resultOfTriangle) {
        return cash.put(triangle, resultOfTriangle);
    }

    public ResultOfTriangle getResultOfCalculations(Triangle triangle) {
        return cash.get(triangle);
    }

    public boolean isExist(Triangle triangle) {
        return cash.containsKey(triangle);
    }


}