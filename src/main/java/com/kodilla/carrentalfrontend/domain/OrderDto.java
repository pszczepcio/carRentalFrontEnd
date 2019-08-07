package com.kodilla.carrentalfrontend.domain;

import java.time.LocalDate;

public class OrderDto {
        private Long id;
        private String orderNumber;
        private LocalDate dateOfOrder;
        private LocalDate dateOfCarRental;
        private LocalDate dateOfReturnCar;
        private boolean statusOrder;
        private double prize;
        private Long userId;
        private Long carId;

    public OrderDto() {
    }

    public OrderDto(Long id, String orderNumber, LocalDate dateOfOrder,
                    LocalDate dateOfCarRental, LocalDate dateOfReturnCar,
                    boolean statusOrder, double prize, Long userId, Long carId) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.dateOfOrder = dateOfOrder;
        this.dateOfCarRental = dateOfCarRental;
        this.dateOfReturnCar = dateOfReturnCar;
        this.statusOrder = statusOrder;
        this.prize = prize;
        this.userId = userId;
        this.carId = carId;
    }

    public Long getId() {
        return id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public LocalDate getDateOfOrder() {
        return dateOfOrder;
    }

    public LocalDate getDateOfCarRental() {
        return dateOfCarRental;
    }

    public LocalDate getDateOfReturnCar() {
        return dateOfReturnCar;
    }

    public boolean isStatusOrder() {
        return statusOrder;
    }

    public double getPrize() {
        return prize;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getCarId() {
        return carId;
    }
}
