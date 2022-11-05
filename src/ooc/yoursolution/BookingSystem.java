/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ooc.yoursolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ooc.enums.Make;

/**
 *
 * @author GAMERS
 */
public class BookingSystem implements BookingSystemInterface {

    int id = 0;

    @Override
    public RentACarInterface setupRentACar(BufferedReader in) throws IOException {
        String name = in.readLine(); // the title will be the first line
        List<CarInterface> cars = new ArrayList<>(); // list to contain cars
        while (in.readLine() != null) {
            /* different data inside the text file so we will split it by the ":"
            it works the same as the delimiter in the scanner
             */
            String[] splitter = in.readLine().split(":");
            Make make = Make.valueOf(splitter[1]); // first part will be the make
            double rate = Double.parseDouble(splitter[2]); // second part will be the rate 
            int numberOfCars = Integer.parseInt(splitter[3]); // third part will be number of cars 

            for (int i = 0; i < numberOfCars; i++) {
                /*we will have at least one car of that make but we can have more than one 
                so each car should be added, that's why I used a for loop that will be used once at least for each
                line.
                each car will have it's own id as well
                 */

                Car newCar = new Car(id, make, rate);
                cars.add(newCar);
                id++;
            }

        }
        RentACarInterface rentACar = new RentACar(name, cars);

        return rentACar;
    }

}
