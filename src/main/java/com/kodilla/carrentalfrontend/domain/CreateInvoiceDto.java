package com.kodilla.carrentalfrontend.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CreateInvoiceDto {
        private Long userId;
        private Long orderId;
}
