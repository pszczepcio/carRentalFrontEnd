package com.kodilla.carrentalfrontend.domain;

public class InvoiceDto {
        private Long id;
        private String invoiceNumber;
        private Long userId;
        private Long orderId;

    public InvoiceDto() {
    }

    public InvoiceDto(Long id, String invoiceNumber, Long userId, Long orderId) {
        this.id = id;
        this.invoiceNumber = invoiceNumber;
        this.userId = userId;
        this.orderId = orderId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
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
