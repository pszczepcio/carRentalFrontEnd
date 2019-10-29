package com.kodilla.carrentalfrontend.workingarea;

import com.kodilla.carrentalfrontend.CarAvailability;
import com.kodilla.carrentalfrontend.client.CarClient;
import com.kodilla.carrentalfrontend.domain.CreateCarDto;
import com.kodilla.carrentalfrontend.mainview.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import lombok.Getter;

public class AddCar {
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
    private Button save = new Button("save");
    private Button cancel = new Button("cancel");
    private HorizontalLayout createCarHorizontalLayoutOne = new HorizontalLayout();
    private HorizontalLayout createCarHorizontalLayoutTwo = new HorizontalLayout();
    private HorizontalLayout createCarHorizontalLayoutThree = new HorizontalLayout();
    private HorizontalLayout createCarHorizontalLayoutFour = new HorizontalLayout();
    @Getter
    private VerticalLayout createCarLayout = new VerticalLayout();
    private MainView mainView;

    public AddCar(MainView mainView) {
        this.mainView = mainView;
        dayOfProduction.setLabel("Day of Production");
        status.setItems(CarAvailability.values());
        createCarHorizontalLayoutOne.add(carClass, typeOfCar, producer);
        createCarHorizontalLayoutTwo.add(model, dayOfProduction, pricePerDay);
        createCarHorizontalLayoutThree.add(color, numberOfSeats,status);
        createCarHorizontalLayoutFour.add(save, cancel);
        createCarLayout.add(createCarHorizontalLayoutOne, createCarHorizontalLayoutTwo,
                createCarHorizontalLayoutThree, createCarHorizontalLayoutFour);
        createCarLayout.setSizeFull();
        saveCar();
        cancelAddingACar();
    }

    private void saveCar() {
        save.addClickListener(event -> {
            CreateCarDto newCar = new CreateCarDto();
            newCar.setCarClass(carClass.getValue());
            newCar.setTypeOfCar(typeOfCar.getValue());
            newCar.setProducer(producer.getValue());
            newCar.setModel(model.getValue());
            newCar.setDayOfProduction(dayOfProduction.getValue().toString());
            newCar.setPricePerDay(Double.parseDouble(pricePerDay.getValue()));
            newCar.setColor(color.getValue());
            newCar.setNumberOfSeats(Integer.parseInt(numberOfSeats.getValue()));
            if (status.getValue().toString().equals("AVAILABLE")) {
                newCar.setAvailability(true);
            }else {
                newCar.setAvailability(false);
            }
            try {
                carClient.createCar(newCar);
                mainView.getPanelTwo().removeAll();
            }catch (NumberFormatException e) {
                Notification.show("You entered the wrong data or did not enter it at all");
            }
        });
    }

    private void cancelAddingACar() {
        cancel.addClickListener(event -> {
            mainView.getPanelTwo().removeAll();
            mainView.getAccordion().close();
        });
    }}
