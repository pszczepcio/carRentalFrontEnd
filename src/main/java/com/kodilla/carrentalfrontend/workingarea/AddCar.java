package com.kodilla.carrentalfrontend.workingarea;

import com.kodilla.carrentalfrontend.Avalilable;
import com.kodilla.carrentalfrontend.client.CarClient;
import com.kodilla.carrentalfrontend.domain.CreateCarDto;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class AddCar {
    private CarClient carClient = new CarClient();
    private TextField carClass = new TextField("Car class:");
    private TextField typeOfCar = new TextField("Type of car:");
    private TextField producer = new TextField("Producer:");
    private TextField model = new TextField("Model:");
    private DatePicker dayOfProduction = new DatePicker();

    //private TextField dayOfProduction = new TextField("Day of Production(year-month-day):");
    private TextField pricePerDay = new TextField("Price per day:");
    private TextField color = new TextField("Color:");
    private TextField numberOfSeats = new TextField("Numbers of seats:");
    private ComboBox<Avalilable> status = new ComboBox<>("Status:");
    private Button saveCar = new Button("save");
    private HorizontalLayout createCarHorizontalLayoutOne = new HorizontalLayout();
    private HorizontalLayout createCarHorizontalLayoutTwo = new HorizontalLayout();
    private HorizontalLayout createCarHorizontalLayoutThree = new HorizontalLayout();
    private VerticalLayout createCarLayout = new VerticalLayout();

    public AddCar() {
        dayOfProduction.setLabel("Day of Production");
        //dayOfProduction.setWidth("300px");
        status.setItems(Avalilable.values());
        createCarHorizontalLayoutOne.add(carClass, typeOfCar, producer);
        createCarHorizontalLayoutTwo.add(model, dayOfProduction, pricePerDay);
        createCarHorizontalLayoutThree.add(color, numberOfSeats,status);
        createCarLayout.add(createCarHorizontalLayoutOne, createCarHorizontalLayoutTwo,
                            createCarHorizontalLayoutThree, saveCar);
        createCarLayout.setSizeFull();
        saveCar.addClickListener(event -> {
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
            carClient.createCar(newCar);
            createCarLayout.setVisible(false);
        });
    }

    public VerticalLayout getCreateCarLayout() {
        return createCarLayout;
    }

    public HorizontalLayout getCreateCarHorizontalLayoutOne() {
        return createCarHorizontalLayoutOne;
    }

    public HorizontalLayout getCreateCarHorizontalLayoutTwo() {
        return createCarHorizontalLayoutTwo;
    }

    public HorizontalLayout getCreateCarHorizontalLayoutThree() {
        return createCarHorizontalLayoutThree;
    }
}
