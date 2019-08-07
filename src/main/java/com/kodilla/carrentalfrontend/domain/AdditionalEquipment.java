package com.kodilla.carrentalfrontend.domain;

public class AdditionalEquipment {
    private Long id;
    private String equipment;
    private double prize;

    public AdditionalEquipment() {
    }

    public AdditionalEquipment(String equipment, double prize) {
        this.equipment = equipment;
        this.prize = prize;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }
}
