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

    ArrayList<CarInterface> carsList;

    public RentACar() {
        carsList = new ArrayList<>();
    }

    @Override
    public List<CarInterface> getCars() {

    }

    @Override
    public void setCars(List<CarInterface> cars) {

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
        for (int i = 0; i < carsList.size(); i++) {
            if (carsList.get(i).getMake().equals(make)) {
                if ((carsList.get(i).isAvailable(month, day)) == true) {
                    available = true;  
                }
            }

        }
        return available;
    }

    @Override
    public int getCarAvailable(Month month, int day, Make make, int lengthOfRent) {

    }

    @Override
    public boolean bookCar(Month month, int day, Make make, int lengthOfRent) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getNumberOfCars() {
        return carsList.size();
    }

}
