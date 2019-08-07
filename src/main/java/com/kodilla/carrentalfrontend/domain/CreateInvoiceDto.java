package com.kodilla.carrentalfrontend.domain;

public class CreateInvoiceDto {
        private Long userId;
        private Long orderId;

    public CreateInvoiceDto() {
    }

    public CreateInvoiceDto(Long userId, Long orderId) {
        this.userId = userId;
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
