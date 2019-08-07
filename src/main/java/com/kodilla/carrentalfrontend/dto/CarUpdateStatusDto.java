package com.kodilla.carrentalfrontend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CarUpdateStatusDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("availability")
    private boolean availability;

    public CarUpdateStatusDto() {
    }

    public CarUpdateStatusDto( @JsonProperty("id")Long id,  @JsonProperty("availability")boolean availability) {
        this.id = id;
        this.availability = availability;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
