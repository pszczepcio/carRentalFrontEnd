package com.kodilla.carrentalfrontend.client;

import com.kodilla.carrentalfrontend.domain.AdditionalEquipment;
import com.kodilla.carrentalfrontend.domain.CreateUserDto;
import com.kodilla.carrentalfrontend.domain.GetEquipmentDto;
import com.kodilla.carrentalfrontend.form.EquipmentForm;
import com.vaadin.flow.component.notification.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import static java.util.Optional.ofNullable;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class EquipmentClient {

    private  RestTemplate restTemplate = new RestTemplate();

    public void createEquipment(final AdditionalEquipment additionalEquipment) {

        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/equipments")
                .queryParam("equipment", additionalEquipment.getEquipment())
                .queryParam("prize", additionalEquipment.getPrize()).build().encode().toUri();
        restTemplate.postForObject(url, additionalEquipment, AdditionalEquipment.class);
    }

    public List<GetEquipmentDto> getEquipments() {
        try {
                       GetEquipmentDto[] equipemntResponse = restTemplate.getForObject(
                    "http://localhost:8080/v1/equipments", GetEquipmentDto[].class);
            return Arrays.asList(ofNullable(equipemntResponse).orElse(new GetEquipmentDto[0]));
        } catch (RestClientException e) {
            return new ArrayList<>();
        }
    }

    public void deleteEquipment(final Long equipmentId){
        try {
            URI url = UriComponentsBuilder.fromHttpUrl(
                    "http://localhost:8080/v1/equipments/")
                    .path(Long.toString(equipmentId)).build().encode().toUri();
            restTemplate.delete(url);
        }catch (RestClientException e) {
            Notification.show("We can't delete equipment, who doesn't exist.");
        }
    }
}
