package com.kodilla.carrentalfrontend.domain;

public class CreateUserDto {
    private Long id;
    private String name;
    private String surname;
    private int phone;
    private String eamil;
    private String password;

    public CreateUserDto() {
    }

    public CreateUserDto(String name, String surname, int phone,
                         String eamil, String password) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.eamil = eamil;
        this.password = password;
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

    public String getEamil() {
        return eamil;
    }

    public void setEamil(String eamil) {
        this.eamil = eamil;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
