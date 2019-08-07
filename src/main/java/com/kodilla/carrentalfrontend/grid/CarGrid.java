package com.kodilla.carrentalfrontend.grid;

import com.kodilla.carrentalfrontend.client.CarClient;
import com.kodilla.carrentalfrontend.domain.CarDto;
import com.kodilla.carrentalfrontend.domain.Equipment;
import com.kodilla.carrentalfrontend.domain.GetCarDto;
import com.kodilla.carrentalfrontend.domain.MainView;
import com.kodilla.carrentalfrontend.form.CarForm;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class CarGrid {
    private Grid<CarDto> carGrid = new Grid<>(CarDto.class);
    private CarClient carClient = new CarClient();
    private VerticalLayout carVerticalLayout = new VerticalLayout();
    private CarForm carForm;

    public CarGrid(MainView mainView) {
        carGrid.setColumns("id", "carClass", "typeOfCar", "producer",
                            "model", "dayOfProduction", "pricePerDay",
                            "color", "numberOfSeats", "availability");
        carGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER,
                GridVariant.LUMO_NO_ROW_BORDERS, GridVariant.LUMO_ROW_STRIPES);


        carGrid.addItemClickListener(event -> {
            carForm = new CarForm(event.getItem().getId());
            carGrid.setVisible(false);
            mainView.getPanelTwo().add(carForm.getCarFormVertical());
            mainView.getPanelTwo().setVisible(true);
            carForm.getCarFormVertical().setVisible(true);
        });
           }

    public void carsRefresh() {
        carGrid.setItems(carClient.getCars());
    }

    public Grid<CarDto> getCarGrid() {
        return carGrid;
    }

    public VerticalLayout getCarVerticalLayout() {
        return carVerticalLayout;
    }

    public CarForm getCarForm() {
        return carForm;
    }
}

