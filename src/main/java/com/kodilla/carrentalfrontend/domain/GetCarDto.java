package com.kodilla.carrentalfrontend.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GetCarDto {
    private Long id;
    private String carClass;
    private String typeOfCar;
    private String producer;
    private String model;
    private LocalDate dayOfProduction;
    private double pricePerDay;
    private String color;
    private int numberOfSeats;
    private boolean availability;
    private List<Long> additionalEquipmentId = new ArrayList<>();
    private String equipment;

    public GetCarDto() {
    }

    public GetCarDto(Long id, String carClass, String typeOfCar,
                     String producer, String model, LocalDate dayOfProduction,
                     double pricePerDay, String color, int numberOfSeats,
                     boolean availability, List<Long> additionalEquipmentId) {
        this.id = id;
        this.carClass = carClass;
        this.typeOfCar = typeOfCar;
        this.producer = producer;
        this.model = model;
        this.dayOfProduction = dayOfProduction;
        this.pricePerDay = pricePerDay;
        this.color = color;
        this.numberOfSeats = numberOfSeats;
        this.availability = availability;
        this.additionalEquipmentId = additionalEquipmentId;
    }

    public GetCarDto(Long id, String carClass, String typeOfCar,
                     String producer, String model, LocalDate dayOfProduction,
                     double pricePerDay, String color, int numberOfSeats,
                     boolean availability, String equipment) {
        this.id = id;
        this.carClass = carClass;
        this.typeOfCar = typeOfCar;
        this.producer = producer;
        this.model = model;
        this.dayOfProduction = dayOfProduction;
        this.pricePerDay = pricePerDay;
        this.color = color;
        this.numberOfSeats = numberOfSeats;
        this.availability = availability;
        this.equipment = equipment;
    }

    public GetCarDto(String equipment) {
        this.equipment = equipment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarClass() {
        return carClass;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    public String getTypeOfCar() {
        return typeOfCar;
    }

    public void setTypeOfCar(String typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getDayOfProduction() {
        return dayOfProduction;
    }

    public void setDayOfProduction(LocalDate dayOfProduction) {
        this.dayOfProduction = dayOfProduction;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public List<Long> getAdditionalEquipmentId() {
        return additionalEquipmentId;
    }

    public void setAdditionalEquipmentId(List<Long> additionalEquipmentId) {
        this.additionalEquipmentId = additionalEquipmentId;
    }

    public String getEquipment() {
        return equipment;
    }
}
