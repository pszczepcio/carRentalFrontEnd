package com.kodilla.carrentalfrontend.client;

import com.kodilla.carrentalfrontend.domain.CreateInvoiceDto;
import com.kodilla.carrentalfrontend.domain.GetInvoiceDto;
import com.kodilla.carrentalfrontend.domain.InvoiceDto;
import com.vaadin.flow.component.notification.Notification;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Optional.ofNullable;

public class InvoiceClient {
    private RestTemplate restTemplate = new RestTemplate();

    public void addInvoice(final CreateInvoiceDto createInvoiceDto) {
        URI url = UriComponentsBuilder.fromHttpUrl(
                "http://localhost:8080/v1/invoices")
                .queryParam("userId", createInvoiceDto.getUserId())
                .queryParam("orderId", createInvoiceDto.getOrderId())
                .build().encode().toUri();
        restTemplate.postForObject(url, createInvoiceDto, CreateInvoiceDto.class);
    }

    public List<GetInvoiceDto> getInvoiceDtoList() {
        try {
            GetInvoiceDto[] getInvoiceDtos = restTemplate.getForObject(
                    "http://localhost:8080/v1/invoices", GetInvoiceDto[].class);
            return Arrays.asList(ofNullable(getInvoiceDtos).orElse(new GetInvoiceDto[0]));
        } catch (RestClientException e) {
            return new ArrayList<>();
        }
    }

    public InvoiceDto getInvoiceDto(long invoiceId) {
        try {
            URI url = UriComponentsBuilder.fromHttpUrl(
                    "http://localhost:8080/v1/invoices/")
                    .path(Long.toString(invoiceId)).build().encode().toUri();
            return restTemplate.getForObject(url, InvoiceDto.class);
        }catch (RestClientException e) {
            Notification.show("We don't have this car !!!");
            return null;
        }
    }

    public void deleteInvoice(final Long invoiceId){
        try {
            URI url = UriComponentsBuilder.fromHttpUrl(
                    "http://localhost:8080/v1/invoices/")
                    .path(Long.toString(invoiceId)).build().encode().toUri();
            restTemplate.delete(url);
        }catch (HttpServerErrorException e) {

        }
    }
}
