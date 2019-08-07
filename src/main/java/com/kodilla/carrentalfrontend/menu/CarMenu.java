package com.kodilla.carrentalfrontend.menu;

import com.kodilla.carrentalfrontend.domain.MainView;
import com.kodilla.carrentalfrontend.form.CarForm;
import com.kodilla.carrentalfrontend.form.EquipmentForm;
import com.kodilla.carrentalfrontend.grid.CarGrid;
import com.kodilla.carrentalfrontend.workingarea.AddCar;
import com.kodilla.carrentalfrontend.workingarea.ReturnCar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class CarMenu {
    private Button showCars = new Button("show cars");
    private Button createCar = new Button("create car");
    private Button returnCar = new Button("return car");
    private VerticalLayout carLayout;
    private CarGrid carsGrid;
    private EquipmentForm equipmentForm = new EquipmentForm();
    private AddCar addCar = new AddCar();
    private ReturnCar returningCar = new ReturnCar();

    public CarMenu(MainView mainView) {
        carsGrid = new CarGrid(mainView);
        showCars.addClickListener(event -> {
            returningCar.getReturnLayout().setVisible(false);
            addCar.getCreateCarLayout().setVisible(false);
            equipmentForm.setVisible(false);
            carsGrid.getCarGrid().setVisible(true);
            mainView.getPanelTwo().setVisible(true);
            mainView.getPanelTwo().addComponentAsFirst(carsGrid.getCarGrid());
            mainView.getPanelTwo().setSizeFull();
            carsGrid.carsRefresh();
            closeCarForm();
        });

        createCar.addClickListener(event -> {
            carsGrid.getCarGrid().setVisible(false);
            closeCarForm();
            returningCar.getReturnLayout().setVisible(false);
            addCar.getCreateCarLayout().setVisible(true);
            mainView.getPanelTwo().add(addCar.getCreateCarLayout());
            mainView.getPanelTwo().setVisible(true);

        });

        returnCar.addClickListener(event -> {
            carsGrid.getCarGrid().setVisible(false);
            closeCarForm();
            returningCar.getReturnLayout().setVisible(true);
            mainView.getPanelTwo().add(returningCar.getReturnLayout());
            mainView.getPanelTwo().setVisible(true);
        });

        carLayout = new VerticalLayout(showCars, createCar, returnCar);
    }

    public VerticalLayout getCarLayout() {
        return carLayout;
    }

    public CarGrid getCarsGrid() {
        return carsGrid;
    }

    public AddCar getAddCar() {
        return addCar;
    }

    public void closeCarForm(){
        try{
            carsGrid.getCarForm().getCarFormVertical().setVisible(false);
        }catch (NullPointerException e){

        }
    }

    public ReturnCar getReturningCar() {
        return returningCar;
    }
}
