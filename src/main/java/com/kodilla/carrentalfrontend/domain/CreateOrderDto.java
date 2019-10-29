package com.kodilla.carrentalfrontend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderDto {
        private String dateOfCarRental;
        private String dateOfReturnCar;
        private Long userId;
        private Long carId;
        private String equipments;
}
