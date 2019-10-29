package com.kodilla.carrentalfrontend.client;

import com.kodilla.carrentalfrontend.domain.CreateOrderDto;
import com.kodilla.carrentalfrontend.domain.OrderDto;
import com.kodilla.carrentalfrontend.domain.UpdateOrderStatus;
import com.vaadin.flow.component.notification.Notification;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Optional.ofNullable;

public class OrderClient {
    private RestTemplate restTemplate = new RestTemplate();
    private OrderDto orderDto;

    public void addOrder(final CreateOrderDto createOrderDto) {
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/orders")
                .queryParam("dateOfCarRental", createOrderDto.getDateOfCarRental())
                .queryParam("dateOfReturnCar", createOrderDto.getDateOfReturnCar())
                .queryParam("userId", createOrderDto.getUserId())
                .queryParam("carId", createOrderDto.getCarId())
                .queryParam("equipments", createOrderDto.getEquipments())
                .build().encode().toUri();
        restTemplate.postForObject(url, createOrderDto, CreateOrderDto.class);
    }

    public List<OrderDto> getOrderDtoList() {
        try {
            OrderDto[] carsResponse = restTemplate.getForObject(
                    "http://localhost:8080/v1/orders", OrderDto[].class);
            return Arrays.asList(ofNullable(carsResponse).orElse(new OrderDto[0]));
        } catch (RestClientException e) {
            return new ArrayList<>();
        }
    }

    public OrderDto getOrderDto(long orderId) {
        try {
            URI url = UriComponentsBuilder.fromHttpUrl(
                    "http://localhost:8080/v1/orders/")
                    .path(Long.toString(orderId)).build().encode().toUri();
            orderDto = restTemplate.getForObject(url, OrderDto.class);

        }catch (RestClientException e) {
            Notification.show("We don't have this car !!!");
            return null;
        }
        return orderDto;
    }

    public void deleteOrder(final Long orderId){
        try {
            URI url = UriComponentsBuilder.fromHttpUrl(
                    "http://localhost:8080/v1/orders/")
                    .path(Long.toString(orderId)).build().encode().toUri();
            restTemplate.delete(url);
        }catch (RestClientException e) {
            Notification.show("We can't delete order, which doesn't exist.");
        }
    }

    public void updateStatus(final UpdateOrderStatus updateOrderStatus){
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/orders/"
                + updateOrderStatus.getOrderId() + "/status/"
                + updateOrderStatus.isOrderStatus()).build().encode().toUri();
        restTemplate.put(url, HttpMethod.PUT);
    }
}
