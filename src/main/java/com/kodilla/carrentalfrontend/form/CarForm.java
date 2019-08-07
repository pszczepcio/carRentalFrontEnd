package com.kodilla.carrentalfrontend.form;

import com.kodilla.carrentalfrontend.Avalilable;
import com.kodilla.carrentalfrontend.client.CarClient;
import com.kodilla.carrentalfrontend.dto.CarUpdateStatusDto;
import com.kodilla.carrentalfrontend.domain.GetCarDto;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

import java.io.IOException;

public class CarForm {
    private VerticalLayout carFormVertical = new VerticalLayout();
    private CarClient carClient = new CarClient();

    public CarForm(Long eventCarId) {
        TextField carClass = new TextField("Car class:");
        TextField typeOfCar = new TextField("Type of car:");
        TextField producer = new TextField("Producer:");
        TextField model = new TextField("Model:");
        DatePicker dayOfProduction = new DatePicker();
        dayOfProduction.setLabel("Day of Production");
        dayOfProduction.setWidth("300px");
        TextField pricePerDay = new TextField("Price per day:");
        TextField color = new TextField("Color:");
        TextField numberOfSeats = new TextField("Numbers of seats:");
        ComboBox<Avalilable> status = new ComboBox<>("Status:");

        Button deleteCar = new Button("delete");
        Button updateCar = new Button("update");
        Button updateCarStatus = new Button("update status");

        HorizontalLayout carFormHorizontalOne = new HorizontalLayout(carClass, typeOfCar, producer);
        HorizontalLayout carFormHorizontalTwo = new HorizontalLayout(model, dayOfProduction, pricePerDay);
        HorizontalLayout carFormHorizontalThree = new HorizontalLayout(color, numberOfSeats, status);
        HorizontalLayout carFormHorizontalFour = new HorizontalLayout(deleteCar, updateCar, updateCarStatus);

        carFormVertical.add(carFormHorizontalOne, carFormHorizontalTwo,
                carFormHorizontalThree, carFormHorizontalFour);
        GetCarDto getCarDto = carClient.getCar(eventCarId);
        carClass.setValue(getCarDto.getCarClass());
        typeOfCar.setValue(getCarDto.getTypeOfCar());
        producer.setValue(getCarDto.getProducer());
        model.setValue(getCarDto.getModel());
        dayOfProduction.setValue(getCarDto.getDayOfProduction());
        pricePerDay.setValue(String.valueOf(getCarDto.getPricePerDay()));
        color.setValue(getCarDto.getColor());
        numberOfSeats.setValue(String.valueOf(getCarDto.getNumberOfSeats()));
        status.setItems(Avalilable.AVAILABLE, Avalilable.UNAVAILABLE);
//        if (getCarDto.isAvailability()) {
//            status.setItems(Avalilable.AVAILABLE, );
//        } else {
//            status.setItems(Avalilable.UNAVAILLABLE);
//        }

        deleteCar.addClickListener(event -> {
            carClient.deleteCar(eventCarId);
            carFormVertical.setVisible(false);
        });

        updateCarStatus.addClickListener(event -> {
//            String value="";
            CarUpdateStatusDto carUpdateStatusDto = new CarUpdateStatusDto();
            carUpdateStatusDto.setId(eventCarId);
            if (status.getValue().toString().equals("AVAILABLE")){
                carUpdateStatusDto.setAvailability(true);
//                    value = "true";
            }else {
                carUpdateStatusDto.setAvailability(false);
//                    value = "false";
            }
//            CarUpdateStatusDto carUpdateStatusDto = new CarUpdateStatusDto(eventCarId.toString(), value);
            try {
                carClient.updateStatus(carUpdateStatusDto);
            } catch (IOException e) {
                e.printStackTrace();
            }
            carFormVertical.setVisible(false);
        });


    }

    public VerticalLayout getCarFormVertical() {
        return carFormVertical;
    }
}
