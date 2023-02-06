package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Transport<T extends IOrder> implements ITransport {
    private int yearOfIssue;
    private String brand;
    private String model;
    private State state;
    private String typeOfFuel;
    private int consumptionPerKm;
    private double currentFuelQuantity;
    private double maxFuelQuantity;
    private String additionalInformation;
    private Optional<List<Order<T>>> orders;

    public Transport(int yearOfIssue, String brand, String model, State state, String typeOfFuel,
                     int consumptionPerKm, double currentFuelQuantity, double maxFuelQuantity) {
        this.yearOfIssue = yearOfIssue;
        this.brand = brand;
        this.model = model;
        this.state = state;
        this.typeOfFuel = typeOfFuel;
        this.consumptionPerKm = consumptionPerKm;
        this.currentFuelQuantity = currentFuelQuantity;
        this.maxFuelQuantity = maxFuelQuantity;
        this.additionalInformation = "the transport is:";
        this.orders = Optional.of(new ArrayList<>());
    }

    public boolean addOrder(Order<T> order) {
        if(orders.isPresent())
            return this.orders.get().add(order);
        return false;
    }
    public boolean removeOrder(Order<T> order){
        if(orders.isPresent() && orders.get().contains(order))
            return orders.get().remove(order);
        return false;
    }
    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation += additionalInformation;
    }

    public Optional<List<Order<T>>> getOrders() {
        return orders;
    }

    public void refuel(double fuelQuantity) {
        if (currentFuelQuantity + fuelQuantity <= maxFuelQuantity)
            currentFuelQuantity += fuelQuantity;
        else
            currentFuelQuantity = maxFuelQuantity;
    }
    public void repair(){
        this.state = State.repaired;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(int yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTypeOfFuel() {
        return typeOfFuel;
    }

    public void setTypeOfFuel(String typeOfFuel) {
        this.typeOfFuel = typeOfFuel;
    }

    public int getConsumptionPerKm() {
        return consumptionPerKm;
    }

    public void setConsumptionPerKm(int consumptionPerKm) {
        this.consumptionPerKm = consumptionPerKm;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public double getCurrentFuelQuantity() {
        return currentFuelQuantity;
    }

    public void setCurrentFuelQuantity(double currentFuelQuantity) {
        this.currentFuelQuantity = currentFuelQuantity;
    }

    public double getMaxFuelQuantity() {
        return maxFuelQuantity;
    }

    public void setMaxFuelQuantity(double maxFuelQuantity) {
        this.maxFuelQuantity = maxFuelQuantity;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }


}
