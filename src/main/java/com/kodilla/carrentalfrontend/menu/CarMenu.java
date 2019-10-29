package com.kodilla.carrentalfrontend.menu;

import com.kodilla.carrentalfrontend.mainview.MainView;
import com.kodilla.carrentalfrontend.grid.CarGrid;
import com.kodilla.carrentalfrontend.workingarea.AddCar;
import com.kodilla.carrentalfrontend.workingarea.ReturnCar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Getter;

@Getter
public class CarMenu {
    private CarGrid carGrid;
    private VerticalLayout carMenuLayout = new VerticalLayout();
    private Button show = new Button("show cars");
    private Button create = new Button("create car");
    private Button returnCar = new Button("return car");
    private MainView mainView;

    public CarMenu(MainView mainView) {
        carGrid = new CarGrid(mainView);
        this.mainView = mainView;
        carMenuLayout.add(show, create, returnCar);
        showCar();
        createCar();
        returnCarToRental();
    }

    private void showCar() {
        show.addClickListener(event -> {
            mainView.getPanelTwo().removeAll();
            mainView.getPanelTwo().add(carGrid.getCarDtoGrid());
            mainView.getPanelTwo().setSizeFull();
            carGrid.carsListRefresh();
        });
    }

    private void createCar() {
        create.addClickListener(event -> {
            mainView.getPanelTwo().removeAll();
            AddCar addCar = new AddCar(mainView);
            mainView.getPanelTwo().add(addCar.getCreateCarLayout());
            mainView.getPanelTwo().setSizeFull();
        });
    }

    private void returnCarToRental() {
        returnCar.addClickListener(event -> {
            mainView.getPanelTwo().removeAll();
            ReturnCar returnCar = new ReturnCar(mainView);
        });
    }
}
