package com.kodilla.carrentalfrontend.client;

import com.kodilla.carrentalfrontend.domain.UserDtoList;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Optional.ofNullable;


public class UserClient {
    private RestTemplate restTemplate = new RestTemplate();

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
