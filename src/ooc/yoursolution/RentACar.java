/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ooc.yoursolution;

import java.util.ArrayList;
import java.util.List;
import ooc.enums.Make;
import ooc.enums.Month;

/**
 *
 * @author GAMERS
 */
public class RentACar implements RentACarInterface {

    String name;

    List<CarInterface> cars;

    public RentACar(String name, List<CarInterface> cars) {
        this.name = name;
        this.cars = cars;

    }

    @Override
    public List<CarInterface> getCars() {

        return cars;
    }

    @Override
    public void setCars(List<CarInterface> cars) {
        this.cars = cars;

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean checkAvailability(Month month, int day, Make make, int lengthOfRent) {
        boolean available = false;
        int test;
        for (CarInterface car : cars) {
            if (car.getMake().equals(make)) {
                test = 0;
                for (int i = 0; i < lengthOfRent; i++) {

                    if (!car.isAvailable(month, day++)) {
                        test = 1;
                        break;
                    }
                }
                if (test == 0) {
                    available = true;

                }
            }
        }
        return available;

    }

    @Override
    public int getCarAvailable(Month month, int day, Make make, int lengthOfRent) {
        /* Normally it should be something like this: if (checkAvailability(month, day, make, lengthOfRent) == false) {
        return car.getID;  but somehow it didn't work so I came up with a less optimal solution
    }*/
        int carId = -1;
        int test;
        for (CarInterface car : cars) {
            if (car.getMake().equals(make)) {
                test = 0;
                for (int i = 0; i < lengthOfRent; i++) {

                    if (!car.isAvailable(month, day++)) {
                        test = 1;
                        break;
                    }
                }
                if (test == 0) {
                    carId = car.getId();
                }
            }
        }

        return carId;
    }

    @Override
    public boolean bookCar(Month month, int day, Make make, int lengthOfRent) {
        if (checkAvailability(month, day, make, lengthOfRent) == false) {
            return false;
        }
        return true;
    }

    @Override
    public int getNumberOfCars() {
        return cars.size();
    }

}
