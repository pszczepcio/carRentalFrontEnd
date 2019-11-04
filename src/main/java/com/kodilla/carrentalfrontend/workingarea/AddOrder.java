package com.kodilla.carrentalfrontend.workingarea;

import com.kodilla.carrentalfrontend.client.EquipmentClient;
import com.kodilla.carrentalfrontend.client.OrderClient;
import com.kodilla.carrentalfrontend.domain.CreateOrderDto;
import com.kodilla.carrentalfrontend.mainview.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AddOrder {
    private DatePicker rentalDate = new DatePicker();
    private DatePicker returnDate = new DatePicker();
    private TextField userId = new TextField("user id");
    private TextField carId = new TextField("car id");
    private ListBox<String> equipments = new ListBox<>();
    private Button addOrder = new Button("Add order");
    private Button cancel = new Button("Cancel");
    private VerticalLayout addOrderVerticalLayout = new VerticalLayout();
    private OrderClient orderClient = new OrderClient();
    private EquipmentClient equipmentClient = new EquipmentClient();
    private List<Checkbox> checkboxList = new ArrayList<>();
    List<String> stringToAdd = new ArrayList<>();
    private List<String> equipmentDtoList;
    private MainView mainView;

    public AddOrder(MainView mainView) {
        this.mainView = mainView;
        equipmentDtoList = equipmentClient.getEquipments().stream()
                .map(a -> a.getEquipment())
                .collect(Collectors.toList());
        for (int i = 0; i < equipmentDtoList.size(); i++) {
            checkboxList.add(new Checkbox(equipmentDtoList.get(i)));
        }
        rentalDate.setLabel("Date of rental car:");
        returnDate.setLabel("Date of return car:");
        HorizontalLayout date = new HorizontalLayout(rentalDate, returnDate);
        HorizontalLayout buttons = new HorizontalLayout(addOrder, cancel);
        addOrderVerticalLayout.add(date, userId, carId, equipments);
        for (int i = 0; i < checkboxList.size(); i++) {
            addOrderVerticalLayout.add(checkboxList.get(i));
        }
        addOrderVerticalLayout.add(buttons);
        addOrder.addClickListener(event -> {
            updateCheckbox();
            CreateOrderDto createOrderDto = new CreateOrderDto(
                    rentalDate.getValue().toString(),
                    returnDate.getValue().toString(),
                    Long.parseLong(userId.getValue()),
                    Long.parseLong(carId.getValue()),
                    getEquipment());
            orderClient.addOrder(createOrderDto);
            addOrderVerticalLayout.setVisible(false);
            clearField();
            addOrderVerticalLayout.setVisible(false);
        });

        cancel.addClickListener(event -> {
            clearField();
            mainView.getPanelTwo().removeAll();
            mainView.getAccordion().close();
        });
    }

    public VerticalLayout getAddOrderVerticalLayout() {
        return addOrderVerticalLayout;
    }

    private void clearField() {
        rentalDate.clear();
        returnDate.clear();
        userId.clear();
        carId.clear();
        for (int i = 0; i < checkboxList.size(); i++) {
            checkboxList.get(i).clear();
        }
    }

    private void updateCheckbox() {
        for (int i = 0; i < equipmentDtoList.size(); i++) {
            if (checkboxList.get(i).getValue())
                stringToAdd.add(checkboxList.get(i).getLabel());
        }
    }

    private String getEquipment() {
        String value = "";
        for (int i = 0; i < stringToAdd.size(); i++) {
            value += stringToAdd.get(i) + ",";
        }
        return value;
    }
}