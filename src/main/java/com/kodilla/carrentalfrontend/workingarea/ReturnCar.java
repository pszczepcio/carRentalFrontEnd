package com.kodilla.carrentalfrontend.workingarea;


import com.kodilla.carrentalfrontend.client.CarClient;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class ReturnCar {
    private TextField carId = new TextField("Id car: ");
    private Button returnCar = new Button("return");
    private VerticalLayout returnLayout = new VerticalLayout();
    private CarClient carClient = new CarClient();

    public ReturnCar() {
        returnLayout.add(carId,returnCar);
        returnCar.addClickListener(event -> {
            carClient.returnCar(Long.parseLong(carId.getValue()));
            returnLayout.setVisible(false);
        });
    }


    public VerticalLayout getReturnLayout() {
        return returnLayout;
    }
}
