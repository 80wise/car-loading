package com.company;

public class Order<T extends IOrder> {
    private T loadedOrder;
    private String pickUpPoint;
    private String destination;
    private double distance;
    private String shortDescription;

    public Order(T loadedOrder, String pickUpPoint, String destination, double distance, String shortDescription) {
        this.loadedOrder = loadedOrder;
        this.pickUpPoint = pickUpPoint;
        this.destination = destination;
        this.distance = distance;
        this.shortDescription = shortDescription;
    }

    public T getLoadedOrder() {
        return loadedOrder;
    }

    @Override
    public String toString() {
        if (loadedOrder instanceof Passengers)
            return "\n The number of passenger from " + pickUpPoint + " to " + destination +
                    " is: " + ((Passengers) loadedOrder).getNumberOfPassengers() +
                    "\n Description: " + shortDescription;
        else if (loadedOrder instanceof Goods)
            return "\n Itinerary: from " + pickUpPoint + " to " + destination +
                    "\n The name of the order is: " + ((Goods) loadedOrder).getName() +
                    "\n  His type is: " + ((Goods) loadedOrder).getType() +
                    "\n  His weight is: " + ((Goods) loadedOrder).getWeight() +
                    "\n  His volume is: " + ((Goods) loadedOrder).getVolume();
        return "";
    }

    public void setLoadedOrder(T loadedOrder) {
        this.loadedOrder = loadedOrder;
    }

    public String getPickUpPoint() {
        return pickUpPoint;
    }

    public void setPickUpPoint(String pickUpPoint) {
        this.pickUpPoint = pickUpPoint;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
}
