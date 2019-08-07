package com.kodilla.carrentalfrontend.menu;

import com.kodilla.carrentalfrontend.client.UserClient;
import com.kodilla.carrentalfrontend.domain.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class SignUp {
    private TextField name = new TextField("Name:");
    private TextField surname = new TextField("Surnmae:");
    private TextField phone = new TextField("Phone:");
    private TextField email = new TextField("Email:");
    private TextField newPassword = new TextField("Password:");
    private Button save = new Button("save");
    private UserClient userClient = new UserClient();
    private VerticalLayout createUserLayout;

    public SignUp(MainView mainView) {
        name.setHeight("50px");
        name.setWidth("150px");
        surname.setHeight("50px");
        surname.setWidth("150px");
        phone.setHeight("50px");
        phone.setWidth("150px");
        email.setHeight("50px");
        email.setWidth("150px");
        newPassword.setHeight("50px");
        newPassword.setWidth("150px");
        save.setHeight("30px");
        save.setWidth("100px");
        save.addThemeName("primary");

        save.addClickListener(event -> {
            userClient.addUser(this);
            name.clear();
            surname.clear();
            phone.clear();
            email.clear();
            newPassword.clear();
            mainView.getAccordion().close();
        });

        createUserLayout = new VerticalLayout(
                name,
                surname,
                phone,
                email,
                newPassword,
                save);
    }

    public TextField getName() {
        return name;
    }

    public TextField getSurname() {
        return surname;
    }

    public TextField getPhone() {
        return phone;
    }

    public TextField getEmail() {
        return email;
    }

    public TextField getNewPassword() {
        return newPassword;
    }

    public VerticalLayout getCreateUserLayout() {
        return createUserLayout;
    }
}
