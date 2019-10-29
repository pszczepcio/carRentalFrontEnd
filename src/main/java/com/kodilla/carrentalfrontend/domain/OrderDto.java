package com.kodilla.carrentalfrontend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
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
}
