package com.kodilla.carrentalfrontend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AdditionalEquipment {
    private Long id;
    private String equipment;
    private double prize;

    public AdditionalEquipment(String equipment, double prize) {
        this.equipment = equipment;
        this.prize = prize;
    }

}
