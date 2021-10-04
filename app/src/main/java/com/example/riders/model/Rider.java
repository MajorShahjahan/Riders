package com.example.riders.model;

import com.example.riders.MainActivity;

import java.util.ArrayList;

public class Rider {
    public String id;
    public String modelIdentifier;
    public String modelName;
    public String name;
    public String make;
    public String group;
    public String color;
    public String series;
    public String fuelType;
    public  String fuelLevel;
    public  String transmission;
    public  String licensePlate;
    public  String latitude;
    public  String longitude;
    public  String innerCleanliness;
    public  String carImageUrl;

    public Rider(ArrayList<Rider> riderList, MainActivity mainActivity){
    }

    public Rider( String id, String modelIdentifier, String modelName, String name,
                  String make, String group, String color, String series, String fuelType,
                  String fuelLevel, String transmission, String licensePlate, String latitude,
                  String longitude, String innerCleanliness, String carImageUrl){
        this.id = id;
        this.modelIdentifier = modelIdentifier;
        this.modelName = modelName;
        this.name = name;
        this.make = make;
        this.group = group;
        this.color = color;
        this.series = series;
        this.fuelType = fuelType;
        this.fuelLevel = fuelLevel;
        this.transmission = transmission;
        this.licensePlate = licensePlate;
        this.latitude = latitude;
        this.longitude = longitude;
        this.innerCleanliness = innerCleanliness;
        this.carImageUrl = carImageUrl;
    }

//    getters
    public String getId() {
        return id;
    }
    public String getModelIdentifier() {
        return modelIdentifier;
    }
    public String getModelName() {
        return modelName;
    }
    public String getName() {
        return name;
    }
    public String getMake() {
        return make;
    }
    public String getGroup() {
        return group;
    }
    public String getColor() { return color; }
    public String getSeries() {
        return series;
    }
    public String getFuelType() {
        return fuelType;
    }
    public String getFuelLevel() {
        return fuelLevel;
    }
    public String getTransmission() {
        return transmission;
    }
    public String getLicensePlate() {
        return licensePlate;
    }
    public String getLatitude() {
        return latitude;
    }
    public String getLongitude() {
        return longitude;
    }
    public String getInnerCleanliness() {
        return innerCleanliness;
    }
    public String getCarImageUrl() {
        return carImageUrl;
    }

//    setters
    public void setId(String id) {
        this.id = id;
    }
    public void setModelIdentifier(String modelIdentifier) {
        this.modelIdentifier = modelIdentifier;
    }
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public void setGroup(String group) {
        this.group = group;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setSeries(String series) {
        this.series = series;
    }
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
    public void setFuelLevel(String fuelLevel) {
        this.fuelLevel = fuelLevel;
    }
    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    public void setInnerCleanliness(String innerCleanliness) {
        this.innerCleanliness = innerCleanliness;
    }
    public void setCarImageUrl(String carImageUrl) {
        this.carImageUrl = carImageUrl;
    }




}
