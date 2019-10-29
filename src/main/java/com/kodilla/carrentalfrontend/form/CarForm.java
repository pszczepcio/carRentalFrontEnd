package com.kodilla.carrentalfrontend.form;

import com.kodilla.carrentalfrontend.CarAvailability;
import com.kodilla.carrentalfrontend.client.CarClient;
import com.kodilla.carrentalfrontend.domain.CarUpdateStatusDto;
import com.kodilla.carrentalfrontend.domain.GetCarDto;
import com.kodilla.carrentalfrontend.grid.CarGrid;
import com.kodilla.carrentalfrontend.mainview.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import lombok.Getter;

import java.io.IOException;

public class CarForm {
    @Getter
    private VerticalLayout carFormLayout = new VerticalLayout();
    private CarClient carClient = new CarClient();
    private TextField carClass = new TextField("Car class:");
    private TextField typeOfCar = new TextField("Type of car:");
    private TextField producer = new TextField("Producer:");
    private TextField model = new TextField("Model:");
    private DatePicker dayOfProduction = new DatePicker();
    private TextField pricePerDay = new TextField("Price per day:");
    private TextField color = new TextField("Color:");
    private TextField numberOfSeats = new TextField("Numbers of seats:");
    private ComboBox<CarAvailability> status = new ComboBox<>("Status:");
    private Button deleteCar = new Button("delete");
    private Button updateCarStatus = new Button("update status");
    private MainView mainView;

    public CarForm(MainView mainView, Long eventCarGridId) {
        this.mainView = mainView;
        dayOfProduction.setLabel("Day of Production");
        dayOfProduction.setWidth("300px");

        carFormLayout.add(new HorizontalLayout(carClass, typeOfCar, producer),
                new HorizontalLayout(model, dayOfProduction, pricePerDay),
                new HorizontalLayout(color, numberOfSeats, status),
                new HorizontalLayout(deleteCar, updateCarStatus));

        GetCarDto getCarDto = carClient.getCar(eventCarGridId);
        carClass.setValue(getCarDto.getCarClass());
        typeOfCar.setValue(getCarDto.getTypeOfCar());
        producer.setValue(getCarDto.getProducer());
        model.setValue(getCarDto.getModel());
        dayOfProduction.setValue(getCarDto.getDayOfProduction());
        pricePerDay.setValue(String.valueOf(getCarDto.getPricePerDay()));
        color.setValue(getCarDto.getColor());
        numberOfSeats.setValue(String.valueOf(getCarDto.getNumberOfSeats()));
        status.setItems(CarAvailability.AVAILABLE, CarAvailability.UNAVAILABLE);

        removeCar(eventCarGridId);
        newStatus(eventCarGridId);
    }

    private void newStatus(Long eventCarGridId) {
        updateCarStatus.addClickListener(event -> {
            CarUpdateStatusDto carUpdateStatusDto = new CarUpdateStatusDto();
            carUpdateStatusDto.setId(eventCarGridId);
            if (status.getValue().toString().equals("AVAILABLE")){
                carUpdateStatusDto.setAvailability(true);
            }else {
                carUpdateStatusDto.setAvailability(false);
            }
            try {
                carClient.updateStatus(carUpdateStatusDto);
                mainView.getPanelTwo().removeAll();
                CarGrid carGrid = new CarGrid(mainView);
                mainView.getPanelTwo().add(carGrid.getCarDtoGrid());
                carGrid.carsListRefresh();
                mainView.getPanelTwo().setSizeFull();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void removeCar(Long eventCarGridId){
        deleteCar.addClickListener(event -> {
            carClient.deleteCar(eventCarGridId);
            carFormLayout.setVisible(false);
        });
    }}
