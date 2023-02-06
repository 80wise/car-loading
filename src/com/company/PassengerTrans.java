package com.company;

public class PassengerTrans extends Transport<Passengers> implements IPassengerTrans {
    private int passengerCapacity;
    private int currentPassengerNumber;

    public PassengerTrans(int yearOfIssue, String brand, String model, State state, String typeOfFuel,
                          int consumptionPerKm, double currentFuelQuantity, double maxFuelQuantity,
                          int passengerCapacity, int currentPassengerNumber) {
        super(yearOfIssue, brand, model, state, typeOfFuel, consumptionPerKm, currentFuelQuantity, maxFuelQuantity);
        this.passengerCapacity = passengerCapacity;
        this.currentPassengerNumber = currentPassengerNumber;
    }

    @Override
    public void disinfect() {
        setAdditionalInformation("disinfected");
    }

    @Override
    public boolean addOrder(Order<Passengers> order) {
        if (order != null && order.getLoadedOrder().getNumberOfPassengers() + currentPassengerNumber <= passengerCapacity)
            if (super.addOrder(order)) {
                this.currentPassengerNumber += order.getLoadedOrder().getNumberOfPassengers();
                return true;
            }
        return false;
    }

    @Override
    public boolean removeOrder(Order<Passengers> order) {
        if (order != null && super.removeOrder(order)) {
            this.currentPassengerNumber -= order.getLoadedOrder().getNumberOfPassengers();
            return true;
        }
        return false;
    }

    @Override
    public StringBuilder getInformationOfThisTransport() {
        StringBuilder info = new StringBuilder("The number of free places is: "
                + (passengerCapacity - currentPassengerNumber) + "\n" +
                "Information about the passengers\n");
        if(getOrders().isPresent()){
            for(Order<Passengers> o:this.getOrders().get()){
                info.append(o.toString());
            }
        }
        return info;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public int getCurrentPassengerNumber() {
        return currentPassengerNumber;
    }

    public void setCurrentPassengerNumber(int currentPassengerNumber) {
        this.currentPassengerNumber = currentPassengerNumber;
    }
}
