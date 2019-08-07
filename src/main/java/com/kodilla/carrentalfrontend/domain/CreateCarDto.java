package com.kodilla.carrentalfrontend.domain;

import java.time.LocalDate;

public class CreateCarDto {
    private String carClass;
    private String typeOfCar;
    private String producer;
    private String model;
    private String dayOfProduction;
    private double pricePerDay;
    private String color;
    private int numberOfSeats;
    private boolean availability;

    public CreateCarDto() {
    }

    public CreateCarDto(String carClass, String typeOfCar, String producer,
                        String model, String dayOfProduction, double pricePerDay,
                        String color, int numberOfSeats, boolean availability) {

        this.carClass = carClass;
        this.typeOfCar = typeOfCar;
        this.producer = producer;
        this.model = model;
        this.dayOfProduction = dayOfProduction;
        this.pricePerDay = pricePerDay;
        this.color = color;
        this.numberOfSeats = numberOfSeats;
        this.availability = availability;
    }

    public String getCarClass() {
        return carClass;
    }

    public String getTypeOfCar() {
        return typeOfCar;
    }

    public String getProducer() {
        return producer;
    }

    public String getModel() {
        return model;
    }

    public String getDayOfProduction() {
        return dayOfProduction;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public String getColor() {
        return color;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    public void setTypeOfCar(String typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDayOfProduction(String dayOfProduction) {
        this.dayOfProduction = dayOfProduction;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
