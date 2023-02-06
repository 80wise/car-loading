package com.company;

public class Goods implements IOrder {
    private String name;
    private GoodsTypes type;
    private double volume;
    private double weight;

    public Goods(String name, GoodsTypes type, double volume, double weight) {
        this.name = name;
        this.type = type;
        this.volume = volume;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GoodsTypes getType() {
        return type;
    }

    public void setType(GoodsTypes type) {
        this.type = type;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
