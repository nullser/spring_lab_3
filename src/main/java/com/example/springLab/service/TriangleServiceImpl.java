package com.example.springLab.service;

import com.example.springLab.classes.ResultOfTriangle;
import com.example.springLab.classes.Triangle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class TriangleServiceImpl implements TriangleService {

    private final Logger logger = LoggerFactory.getLogger(TriangleServiceImpl.class);


    @Cacheable("triangle")
    public ResultOfTriangle calculate(Triangle triangle) throws InterruptedException {

        if(triangle.checkingTriangle()) {

            try {


                Thread.sleep(5000);
                logger.info("Perimeter and square have been calculate SUCCESSFULLY");
                return new ResultOfTriangle(
                        true,
                        triangle.findPerimeter(),
                        triangle.findSquare()

                );
            }
            catch (InterruptedException e){}
        }
        else{
            logger.error("ERROR. Triangle doesn't exist!");
            return new ResultOfTriangle(
                    false,
                    0,
                    0
            );
        }

        return null;
    }
}
