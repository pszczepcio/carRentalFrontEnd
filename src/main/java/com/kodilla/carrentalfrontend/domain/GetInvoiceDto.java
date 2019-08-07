package com.kodilla.carrentalfrontend.domain;

public class GetInvoiceDto {
        private Long id;
        private String invoiceNumber;

    public GetInvoiceDto() {
    }

    public GetInvoiceDto(Long id, String invoiceNumber) {
        this.id = id;
        this.invoiceNumber = invoiceNumber;
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
}
