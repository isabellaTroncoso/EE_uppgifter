package org.example;

import org.example.IMammal;
import org.example.IReptile;

public class AnimalUtil {

    public static void checkAnimalType(IAnimal animal) {
        if (animal instanceof IMammal) {
            System.out.println("Detta djur är ett däggdjur.");
        }

        if (animal instanceof IReptile) {
            System.out.println("Detta djur är en reptil.");
        }
    }
}
