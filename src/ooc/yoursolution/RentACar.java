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

    List<CarInterface> cars;  // list containing cars' List
    CarInterface availableCar;

    // constructor needed for the bookinSystem class
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

    /*checkAvailability:
    this method will check the make of the car from the cars' list and then it will check its
    availability on the given month and day, if it is available the day will advance covering the whole
    length of rent
    used the test integer as a condition to help exit the loop and verify availability
    NOTICE: The availableCar will be used in the getCarAvailable 
     */
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
                    availableCar = car;

                }
            }
        }
        return available;

    }

    /*
    getCarAvailable:
    it will check the checkAvailablity method and if it's true it will return the car ID of the available car
    remember we identified availableCar in the checkAvailablity method
    
     */
    @Override
    public int getCarAvailable(Month month, int day, Make make, int lengthOfRent) {

        int carId = -1;
        if (checkAvailability(month, day, make, lengthOfRent) == true) {
            carId = availableCar.getId();
        }

        return carId;
    }
    
/*
    if the car is not available, the booking won't happen and it will return false
    if the car is available, we get the car id and check the make, we use the book class 
    from the car method and return true
    */
    @Override
    public boolean bookCar(Month month, int day, Make make, int lengthOfRent) {
        if (checkAvailability(month, day, make, lengthOfRent) == false) {
            return false;
        }
        int carId = getCarAvailable(month, day, make, lengthOfRent);
        for (CarInterface car : cars) {
            if ((car.getId() == carId) && (car.getMake() == make)) {
                for (int i = 0; i < lengthOfRent; i++) {
                    car.book(month, day++);
                }
            }
        }

        return true;
    }

    @Override
    public int getNumberOfCars() {
        return cars.size();
    }

}
