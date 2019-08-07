package com.kodilla.carrentalfrontend.domain;

public class CreateOrderDto {
        private String dateOfCarRental;
        private String dateOfReturnCar;
        private Long userId;
        private Long carId;
        private String equipments;

    public CreateOrderDto() {
    }

    public CreateOrderDto(String dateOfCarRental, String dateOfReturnCar, Long userId, Long carId, String equipments) {
        this.dateOfCarRental = dateOfCarRental;
        this.dateOfReturnCar = dateOfReturnCar;
        this.userId = userId;
        this.carId = carId;
        this.equipments = equipments;
    }

    public String getDateOfCarRental() {
        return dateOfCarRental;
    }

    public String getDateOfReturnCar() {
        return dateOfReturnCar;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setDateOfCarRental(String dateOfCarRental) {
        this.dateOfCarRental = dateOfCarRental;
    }

    public void setDateOfReturnCar(String dateOfReturnCar) {
        this.dateOfReturnCar = dateOfReturnCar;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getEquipments() {
        return equipments;
    }

    public void setEquipments(String equipments) {
        this.equipments = equipments;
    }
}
