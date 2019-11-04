package com.kodilla.carrentalfrontend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateUserDto {
    private Long id;
    private String name;
    private String surname;
    private int phone;
    private String eamil;
    private String password;

    public CreateUserDto(String name, String surname, int phone,
                         String eamil, String password) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.eamil = eamil;
        this.password = password;
    }
}
