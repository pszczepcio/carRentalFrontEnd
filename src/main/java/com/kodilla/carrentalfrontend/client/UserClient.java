package com.kodilla.carrentalfrontend.client;

import com.kodilla.carrentalfrontend.domain.CarDto;
import com.kodilla.carrentalfrontend.domain.CreateUserDto;
import com.kodilla.carrentalfrontend.dto.UserDto;
import com.kodilla.carrentalfrontend.dto.UserDtoList;
import com.kodilla.carrentalfrontend.menu.SignUp;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.data.binder.Binder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Optional.ofNullable;

@Component
public class UserClient {
    RestTemplate restTemplate = new RestTemplate();
    private UserDto userDto = new UserDto();

        public CreateUserDto addUser(final SignUp signUp){
           if (checkFieldsInSignUp(signUp)) {
               CreateUserDto createUserDto = new CreateUserDto();
               createUserDto.setName(signUp.getName().getValue());
               createUserDto.setSurname(signUp.getSurname().getValue());
               createUserDto.setPhone(Integer.parseInt(signUp.getPhone().getValue()));
               createUserDto.setEamil(signUp.getEmail().getValue());
               createUserDto.setPassword(signUp.getNewPassword().getValue());

               URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/users")
                       .queryParam("name", createUserDto.getName())
                       .queryParam("surname", createUserDto.getSurname())
                       .queryParam("phone", createUserDto.getPhone())
                       .queryParam("email", createUserDto.getEamil())
                       .queryParam("password", createUserDto.getPassword()).build().encode().toUri();
               return restTemplate.postForObject(url, createUserDto, CreateUserDto.class);
           }else {
               return null;
           }
        }

    public List<UserDtoList> getCars() {
        try {
            UserDtoList[] usersResponse = restTemplate.getForObject(
                    "http://localhost:8080/v1/users", UserDtoList[].class);
            return Arrays.asList(ofNullable(usersResponse).orElse(new UserDtoList[0]));
        } catch (RestClientException e) {
            return new ArrayList<>();
        }
    }

    public UserDto getUser(final Long id) {
        try {
            URI url = UriComponentsBuilder.fromHttpUrl(
                    "http://localhost:8080/v1/users/")
                    .path(Long.toString(id)).build().encode().toUri();
            userDto = restTemplate.getForObject(url, UserDto.class);
            return userDto;
        }catch (RestClientException e) {
            Notification.show("We don't have this car !!!");
            return null;
        }
    }

    public void deleteUser(final Long userId){
        try {
            URI url = UriComponentsBuilder.fromHttpUrl(
                    "http://localhost:8080/v1/users/")
                    .path(Long.toString(userId)).build().encode().toUri();
            restTemplate.delete(url);
        }catch (RestClientException e) {
            Notification.show("We can't delete user, who doesn't exist or you must return car to rental");
        }
    }

    private boolean checkFieldsInSignUp(final SignUp signUp) {
        if (signUp.getName() != null && (!signUp.getName().getValue().equals("")) &&
                signUp.getNewPassword() != null && (!signUp.getNewPassword().getValue().equals("")) &&
                signUp.getSurname() != null && (!signUp.getSurname().getValue().equals("")) &&
                signUp.getEmail() != null && (!signUp.getEmail().getValue().equals("")) &&
                signUp.getPhone() != null && (!signUp.getPhone().getValue().equals("")))
            return true;
        else {
            return false;
        }
    }
}
