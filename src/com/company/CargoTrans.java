package com.company;

import java.util.Arrays;
import java.util.HashSet;

public class CargoTrans extends Transport<Goods> implements ICargoTrans {
    private Body body;

    public CargoTrans(int yearOfIssue, String brand, String model, State state, String typeOfFuel,
                      int consumptionPerKm, double currentFuelQuantity, double maxFuelQuantity, Body body) {
        super(yearOfIssue, brand, model, state, typeOfFuel, consumptionPerKm, currentFuelQuantity, maxFuelQuantity);
        this.body = body;
    }

    @Override
    public boolean addOrder(Order<Goods> goods) {
        if (goods != null && body.getTypesOfGoods().contains((goods).getLoadedOrder().getType())
                && goods.getLoadedOrder().getWeight() + body.getCurrentlyLoaded() <= body.getLoadCapacity()
                && goods.getLoadedOrder().getVolume() + body.getCurrentlyOccupiedVolume() <= body.getVolume())
            if (super.addOrder(goods)) {
                this.body.setCurrentlyLoaded(body.getCurrentlyLoaded() + goods.getLoadedOrder().getWeight());
                this.body.setCurrentlyOccupiedVolume(body.getCurrentlyOccupiedVolume() + goods.getLoadedOrder().getVolume());
                return true;
            }
        return false;
    }

    @Override
    public boolean removeOrder(Order<Goods> order) {
        if (order != null && super.removeOrder(order)) {
            this.body.setCurrentlyOccupiedVolume(body.getCurrentlyOccupiedVolume() - order.getLoadedOrder().getVolume());
            this.body.setCurrentlyLoaded(body.getCurrentlyLoaded() - order.getLoadedOrder().getWeight());
            return true;
        }
        return false;
    }

    @Override
    public StringBuilder getInformationOfThisTransport() {
        StringBuilder info = new StringBuilder("the free volume is: " + (body.getVolume() - body.getCurrentlyOccupiedVolume()) + "\n" +
                "the free weight is: " + (body.getLoadCapacity() - body.getCurrentlyLoaded()) + "\n" +
                "Information about the transported goods:\n");
        if (getOrders().isPresent()) {
            for (Order<Goods> o : this.getOrders().get()) {
                info.append(o.toString());
            }
        }
        return info;
    }

    @Override
    public void seal() {
        setAdditionalInformation("Seal");
    }
}
