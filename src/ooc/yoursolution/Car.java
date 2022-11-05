/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ooc.yoursolution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import ooc.enums.Make;
import ooc.enums.Month;

/**
 *
 * @author GAMERS
 */
public class Car implements CarInterface {

    private double rate;
    private Make make;
    private int id;
    private Map<Month, boolean[]> availabilityMap;

    // constructor needed for the bookingSystem class because the text file already contains some information about the car 
    public Car(int id, Make make, double rate) { 
        this.id = id;
        this.make = make;
        this.rate = rate;
        createAvailability();
    }

    @Override
    public Map<Month, boolean[]> createAvailability() {
        availabilityMap = new HashMap<Month, boolean[]>();
        for (Month month : Month.values()) {
            boolean[] monthAvailability = new boolean[month.getNumberOfDays()];
            Arrays.fill(monthAvailability, true);
            availabilityMap.put(month, monthAvailability);
//At first the car will be available for the whole year so the availability map will have all the month values
        }
        return availabilityMap;
    }

    @Override
    public Make getMake() {
        return make; 
    }

    @Override
    public void setMake(Make make) {
        this.make = make;
    }

    @Override
    public double getRate() {
        return rate;
    }

    @Override
    public void setRate(double rate) {
        this.rate = rate;

    }

    @Override
    public Map<Month, boolean[]> getAvailability() {
        return this.availabilityMap;

    }

    @Override
    public void setAvailability(Map<Month, boolean[]> availability) {
        this.availabilityMap = availability;

    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public boolean isAvailable(Month month, int day) {
        boolean[] availability = availabilityMap.get(month);
        return availability[day];
        // checks the submitted month if it's available and then the day, returns true if it's available and false if it's not
    }

    @Override
    public boolean book(Month month, int day) {
        if (isAvailable(month, day)) {
            availabilityMap.get(month)[day] = false;
            return true;
        } else {
            return false;
        }
// check from the previous isAvailable by putting the month and the day
    }

}
