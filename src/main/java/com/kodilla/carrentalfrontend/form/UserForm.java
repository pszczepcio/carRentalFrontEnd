package com.kodilla.carrentalfrontend.form;

import com.kodilla.carrentalfrontend.domain.CreateUserDto;
import com.kodilla.carrentalfrontend.domain.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class UserForm extends FormLayout{
    private TextField name = new TextField("Name:");
    private TextField surname = new TextField("Surnmae:");
    private TextField phone = new TextField("Phone:");
    private TextField email = new TextField("Email:");
    private TextField password = new TextField("Password:");
    private Button save = new Button("Save");
    private Binder<CreateUserDto> binder = new Binder<>(CreateUserDto.class);
    private MainView mainView;

    public UserForm(MainView mainView) {
        this.mainView = mainView;
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        VerticalLayout buttons = new VerticalLayout(name,surname, phone, email, password, save);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(buttons);
    }

    public void setCreateUserDto(CreateUserDto createUserDto) {
        binder.setBean(createUserDto);
        if (createUserDto == null) {
            setVisible(false);
        } else {
            setVisible(true);
            name.focus();
        }
    }
}
