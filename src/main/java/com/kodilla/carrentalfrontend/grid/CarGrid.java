package com.kodilla.carrentalfrontend.grid;

import com.kodilla.carrentalfrontend.client.CarClient;
import com.kodilla.carrentalfrontend.domain.CarDto;
import com.kodilla.carrentalfrontend.mainview.MainView;
import com.kodilla.carrentalfrontend.form.CarForm;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import lombok.Getter;

@Getter
public class CarGrid {
    private CarClient carClient = new CarClient();
    private Grid<CarDto> carDtoGrid = new Grid<>(CarDto.class);

    public CarGrid(MainView mainView) {
        carDtoGrid.setColumns("id", "carClass", "typeOfCar", "producer",
                "model", "dayOfProduction", "pricePerDay",
                "color", "numberOfSeats", "availability");
        carDtoGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER,
                GridVariant.LUMO_NO_ROW_BORDERS, GridVariant.LUMO_ROW_STRIPES);
        carDtoGrid.addItemClickListener(event -> {
            mainView.getPanelTwo().removeAll();
            CarForm carForm = new CarForm(mainView, event.getItem().getId());
            mainView.getPanelTwo().add((carForm.getCarFormLayout()));
            mainView.getPanelTwo().setSizeFull();
        });
    }

    public void carsListRefresh() {
        carDtoGrid.setItems(carClient.getCars());
    }
}

