package com.kodilla.carrentalfrontend.workingarea;

import com.kodilla.carrentalfrontend.client.CarClient;
import com.kodilla.carrentalfrontend.mainview.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

import static com.helger.commons.string.StringParser.isLong;

public class ReturnCar {
    private VerticalLayout returnCarLayout = new VerticalLayout();
    private TextField carId = new TextField("Id car: ");
    private Button returnCar = new Button("return");
    private MainView mainView;

    public ReturnCar(MainView mainView) {
        this.mainView = mainView;
        returnCarLayout.add(carId, returnCar);
        mainView.getPanelTwo().add(returnCarLayout);
        returnCarToRental();
    }

    private void returnCarToRental() {
        returnCar.addClickListener(event -> {
            if(isLong(carId.getValue())) {
                System.out.println(carId.getValue());
                CarClient carClient = new CarClient();
                carClient.returnCar(Long.parseLong(carId.getValue()));
                carId.clear();
                mainView.getPanelTwo().removeAll();
                mainView.getAccordion().close();
            }else {
                carId.clear();
                Notification.show("Invalid data entered. Please enter a number.");
            }
        });
    }
}
