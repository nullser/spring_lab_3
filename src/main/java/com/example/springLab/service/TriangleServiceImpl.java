package com.example.springLab.service;


import com.example.springLab.classes.ResultOfTriangle;
import com.example.springLab.classes.Triangle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TriangleServiceImpl implements TriangleService {

    private final Logger logger = LoggerFactory.getLogger(TriangleServiceImpl.class);


    public ResultOfTriangle calculate(Triangle triangle) {

        if(triangle.checkingTriangle()) {
            logger.info("Perimeter and square have been calculate SUCCESSFULLY");
            return new ResultOfTriangle(
                    true,
                    triangle.findPerimeter(),
                    triangle.findSquare()

            );
        }
        else{
            logger.error("ERROR. Triangle doesn't exist!");
            return new ResultOfTriangle(
                    false,
                    0,
                    0
            );
        }

    }
}
