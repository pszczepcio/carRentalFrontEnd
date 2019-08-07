package com.kodilla.carrentalfrontend.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDto {
    private Long id;
    private String name;
    private String surname;
    private int phone;
    private String email;
    private boolean loginStatus;
    private List<Long> orderIdList = new ArrayList<>();
    private List<Long> invoiceIdList = new ArrayList<>();

    public UserDto() {
    }

    public UserDto(Long id, String name, String surname,
                   int phone, String email, boolean loginStatus,
                   List<Long> orderIdList, List<Long> invoiceIdList) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.loginStatus = loginStatus;
        this.orderIdList = orderIdList;
        this.invoiceIdList = invoiceIdList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public List<Long> getOrderIdList() {
        return orderIdList;
    }

    public void setOrderIdList(List<Long> orderIdList) {
        this.orderIdList = orderIdList;
    }

    public List<Long> getInvoiceIdList() {
        return invoiceIdList;
    }

    public void setInvoiceIdList(List<Long> invoiceIdList) {
        this.invoiceIdList = invoiceIdList;
    }
}
