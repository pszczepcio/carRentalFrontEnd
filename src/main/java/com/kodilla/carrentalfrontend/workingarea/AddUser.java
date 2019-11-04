package com.kodilla.carrentalfrontend.workingarea;

import com.kodilla.carrentalfrontend.client.UserClient;
import com.kodilla.carrentalfrontend.domain.CreateUserDto;
import com.kodilla.carrentalfrontend.mainview.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import lombok.Getter;

public class AddUser {
    @Getter
    private VerticalLayout addUserLayout = new VerticalLayout();
    private MainView mainView;
    private TextField name = new TextField("Name:");
    private TextField surname = new TextField("Surname:");
    private TextField phone = new TextField("Phone number:");
    private TextField mail = new TextField("Email:");
    private TextField password = new TextField("Password:");
    private Button createUser = new Button("new user");
    private Button cancel = new Button("cancel");
    private UserClient userClient = new UserClient();

    public AddUser(MainView mainView) {
        this.mainView = mainView;
        createUser.addThemeName("primary");
        addUserLayout.add(name, surname, phone, mail,
                password, new HorizontalLayout(createUser, cancel));
        createNewUser();
        cancelCreateUser();
    }

    private void createNewUser() {
        createUser.addClickListener(event -> {
            CreateUserDto createUserDto = new CreateUserDto(
                    name.getValue(),
                    surname.getValue(),
                    Integer.parseInt(phone.getValue()),
                    mail.getValue(),
                    password.getValue()
            );
            try {
                userClient.createUser(createUserDto);
                clearFields();
                mainView.getPanelTwo().removeAll();
            }catch (Exception e) {
                Notification.show("You entered the wrong data or did not enter it at all");
                System.out.println("Add user exception " + e);
            }
        });
    }

    private void cancelCreateUser(){
        cancel.addClickListener(event -> {
            clearFields();
            mainView.getPanelTwo().removeAll();
            mainView.getAccordion().close();
        });
    }

    private void clearFields() {
        name.clear();
        surname.clear();
        phone.clear();
        mail.clear();
        password.clear();
    }
}
