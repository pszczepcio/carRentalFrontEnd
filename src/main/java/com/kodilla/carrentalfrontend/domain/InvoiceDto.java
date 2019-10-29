package com.kodilla.carrentalfrontend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {
        private Long id;
        private String invoiceNumber;
        private Long userId;
        private Long orderId;
}
