package com.kodilla.carrentalfrontend.client;

import com.kodilla.carrentalfrontend.domain.CreateCarDto;
import com.kodilla.carrentalfrontend.domain.CreateUserDto;
import com.kodilla.carrentalfrontend.domain.UserDtoList;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Optional.ofNullable;

public class UserClient {
    private RestTemplate restTemplate = new RestTemplate();

    public void createUser(final CreateUserDto createUserDto) {
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/users")
                .queryParam("name", createUserDto.getName())
                .queryParam("surname", createUserDto.getSurname())
                .queryParam("phone", createUserDto.getPhone())
                .queryParam("email", createUserDto.getEamil())
                .queryParam("password", createUserDto.getPassword())
                .build().encode().toUri();
        restTemplate.postForObject(url, createUserDto, CreateCarDto.class);
    }

    public List<UserDtoList> getUsers() {
        try {
            UserDtoList[] usersResponse = restTemplate.getForObject(
                    "http://localhost:8080/v1/users", UserDtoList[].class);
            return Arrays.asList(ofNullable(usersResponse).orElse(new UserDtoList[0]));
        }catch (RestClientException e) {
            return new ArrayList<>();
        }
    }
}
