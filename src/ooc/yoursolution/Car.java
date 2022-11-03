/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ooc.yoursolution;

import java.util.HashMap;
import java.util.Map;
import ooc.enums.Make;
import ooc.enums.Month;

/**
 *
 * @author GAMERS
 */
public class Car implements CarInterface {

    double rate;
    Make make;
    Month month;
    int id;
    Map<Month, boolean[]> availabilityMap;
    boolean[] value;

    public Car() {
    }

    @Override
    public Map<Month, boolean[]> createAvailability() {
        availabilityMap = new HashMap<Month, boolean[]>();
        availabilityMap.put(month, value);
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
        boolean available = false;
        for (int i = 0; i < availabilityMap.size(); i++) {
            if (availabilityMap.get(i).equals(month)) {
                for (int j = 0; j < availabilityMap.size(); j++) {
                    if (availabilityMap.get(i).equals(day)) {
                        available = true;

                    }

                }
            }
        }
        return available;
        // i wanted to iterate through the whole map but I knew this is not the way to
    }

    @Override
    public boolean book(Month month, int day) {
        boolean book = this.isAvailable(month, day);
        return book;
        

    }

}
