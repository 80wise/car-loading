package com.company;

import java.util.Arrays;
import java.util.HashSet;

public class Body {
    private double volume;
    private double loadCapacity;
    private double currentlyLoaded;
    private double currentlyOccupiedVolume;
    private BodyType bodyType;
    private HashSet<GoodsTypes> typesOfGoods;

    public Body(double volume, double loadCapacity, double currentlyLoaded,
                double currentlyOccupiedVolume, BodyType bodyType, GoodsTypes... typesOfGoods) {
        this.volume = volume;
        this.loadCapacity = loadCapacity;
        this.currentlyLoaded = currentlyLoaded;
        this.currentlyOccupiedVolume = currentlyOccupiedVolume;
        this.bodyType = bodyType;
        this.typesOfGoods = new HashSet<>(Arrays.asList(typesOfGoods));
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public double getCurrentlyLoaded() {
        return currentlyLoaded;
    }

    public void setCurrentlyLoaded(double currentlyLoaded) {
        this.currentlyLoaded = currentlyLoaded;
    }

    public double getCurrentlyOccupiedVolume() {
        return currentlyOccupiedVolume;
    }

    public void setCurrentlyOccupiedVolume(double currentlyOccupiedVolume) {
        this.currentlyOccupiedVolume = currentlyOccupiedVolume;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    public HashSet<GoodsTypes> getTypesOfGoods() {
        return typesOfGoods;
    }

    public void setTypesOfGoods(GoodsTypes... typesOfGoods) {
        this.typesOfGoods = new HashSet<>(Arrays.asList(typesOfGoods));
    }

    public void AddOneTypeOfGood(GoodsTypes type){
        this.typesOfGoods.add(type);
    }
}
