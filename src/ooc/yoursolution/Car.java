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

    public Car(int id,Make make,double rate) {
    }

    @Override
    public Map<Month, boolean[]> createAvailability() {
        availabilityMap = new HashMap<Month, boolean[]>();
        for (Month month : Month.values()) {
            boolean[] monthAvailability = new boolean[month.getNumberOfDays()];
            Arrays.fill(monthAvailability, true);
            availabilityMap.put(month, monthAvailability);

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
    }

    @Override
    public boolean book(Month month, int day) {
        if (isAvailable(month, day)) {
            availabilityMap.get(month)[day] = false;
            return true;
        } else {
            return false;
        }

    }

}
