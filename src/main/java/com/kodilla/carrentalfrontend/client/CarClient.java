package com.kodilla.carrentalfrontend.client;


import com.kodilla.carrentalfrontend.domain.*;
import com.kodilla.carrentalfrontend.domain.CarUpdateStatusDto;
import com.vaadin.flow.component.notification.Notification;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

public class CarClient {
    private RestTemplate restTemplate = new RestTemplate();
    private GetCarDto getCarDto = new GetCarDto();
    private EquipmentClient equipmentClient = new EquipmentClient();
    private int i;
    private String equipments ="";

    public List<CarDto> getCars() {
        try {
            CarDto[] carsResponse = restTemplate.getForObject(
                    "http://localhost:8080/v1/cars", CarDto[].class);
            return Arrays.asList(ofNullable(carsResponse).orElse(new CarDto[0]));
        } catch (RestClientException e) {
            return new ArrayList<>();
        }
    }

    public GetCarDto getCar(final Long id) {
        try {
            URI url = UriComponentsBuilder.fromHttpUrl(
                    "http://localhost:8080/v1/cars/")
                    .path(Long.toString(id)).build().encode().toUri();
            getCarDto = restTemplate.getForObject(url, GetCarDto.class);
            int size = getCarDto.getAdditionalEquipmentId().size();
            List<GetEquipmentDto> equipmentDtoList = equipmentClient.getEquipments();
            for (i = 0 ; i < size ; i++ ) {
                String equipment = equipmentDtoList.stream()
                        .filter(e -> e.getId().equals(getCarDto.getAdditionalEquipmentId().get(i)))
                        .map(e -> e.getEquipment())
                        .map(e -> e.concat(", "))
                        .collect(Collectors.joining());
                equipments += equipment;
            }
            return new GetCarDto(
                    getCarDto.getId(),
                    getCarDto.getCarClass(),
                    getCarDto.getTypeOfCar(),
                    getCarDto.getProducer(),
                    getCarDto.getModel(),
                    getCarDto.getDayOfProduction(),
                    getCarDto.getPricePerDay(),
                    getCarDto.getColor(),
                    getCarDto.getNumberOfSeats(),
                    getCarDto.isAvailability(),
                    equipments
            );
        }catch (RestClientException e) {
            Notification.show("We don't have this car !!!");
            return null;
        }
    }

    public void createCar(final CreateCarDto createCarDto) {
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/cars")
                .queryParam("carClass", createCarDto.getCarClass())
                .queryParam("typeOfCar", createCarDto.getTypeOfCar())
                .queryParam("producer", createCarDto.getProducer())
                .queryParam("model", createCarDto.getModel())
                .queryParam("dayOfProduction", createCarDto.getDayOfProduction())
                .queryParam("pricePerDay", createCarDto.getPricePerDay())
                .queryParam("color", createCarDto.getColor())
                .queryParam("numberOfSeats", createCarDto.getNumberOfSeats())
                .queryParam("availability", createCarDto.isAvailability()).build().encode().toUri();
        restTemplate.postForObject(url, createCarDto, CreateCarDto.class);
    }

    public void returnCar(final Long carId){
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/cars/")
                .path(carId.toString()).build().encode().toUri();

        restTemplate.put(url,String.class);
    }

    public void deleteCar(final Long carId){
        try {
            URI url = UriComponentsBuilder.fromHttpUrl(
                    "http://localhost:8080/v1/cars/")
                    .path(Long.toString(carId)).build().encode().toUri();
            restTemplate.delete(url);
        }catch (RestClientException e) {
            Notification.show("We can't delete car, which doesn't exist.");
        }
    }

    public void updateStatus(final CarUpdateStatusDto carUpdateStatusDto) throws IOException {
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/cars/" + carUpdateStatusDto.getId()
                + "/status/" +carUpdateStatusDto.isAvailability()).build().encode().toUri();
        restTemplate.put(url, HttpMethod.PUT);
    }
}
