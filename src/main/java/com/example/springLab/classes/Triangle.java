package com.example.springLab.classes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Triangle {

    private float sideFirst;
    private float sideSecond;
    private float sideThird;

    public boolean checkingTriangle(){
        if(sideFirst + sideSecond < sideThird ||
                sideFirst + sideThird < sideSecond || sideSecond + sideThird < sideFirst) {
            return false;
        }
        else
            return true;
    }

    public float findSquare(){
        float perimeter = findPerimeter()/2;
        return (float)Math.sqrt(perimeter*(perimeter - sideFirst)*(perimeter - sideSecond)*(perimeter - sideThird));
    }

    public float findPerimeter(){
        return sideFirst + sideSecond + sideThird;
    }

}
