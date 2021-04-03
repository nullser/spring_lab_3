package com.example.springLab.classes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultOfTriangle {

    final private boolean isTriangleExist;
    final private float perimeter;
    final private float square;

}
