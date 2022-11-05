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

    @Override
    public RentACarInterface setupRentACar(BufferedReader in) throws IOException {
        String name = in.readLine();
        List<CarInterface> cars = new ArrayList<>();
        while (in.readLine() != null) {
            String[] splitter = in.readLine().split(":");
            Make make = Make.valueOf(splitter[1]);
            double rate = Double.parseDouble(splitter[2]);
            int numberOfCars = Integer.parseInt(splitter[3]);
            for (int i = 0; i < numberOfCars; i++) {
                int id = 0;
                Car newCar = new Car(id, make, rate);
                cars.add(newCar);

            }

        }
        RentACarInterface carRental = new RentACar(name, cars);

        return carRental;
    }

}
