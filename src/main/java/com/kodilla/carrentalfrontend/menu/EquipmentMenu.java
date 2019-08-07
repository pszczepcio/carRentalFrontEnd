package com.kodilla.carrentalfrontend.menu;

import com.kodilla.carrentalfrontend.client.EquipmentClient;
import com.kodilla.carrentalfrontend.domain.GetEquipmentDto;
import com.kodilla.carrentalfrontend.domain.MainView;
import com.kodilla.carrentalfrontend.form.EquipmentForm;
import com.kodilla.carrentalfrontend.workingarea.DeleteEquipment;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class EquipmentMenu {
    private EquipmentClient equipmentClient = new EquipmentClient();
    private Grid<GetEquipmentDto> grid = new Grid<>(GetEquipmentDto.class);
    private Button equipment = new Button("show");
    private Button addEquipment = new Button("add");
    private Button deleteEquipment = new Button("delete");
    private VerticalLayout equipmentLayout;
    private EquipmentForm equipmentForm = new EquipmentForm();
    private DeleteEquipment removeEquipment = new DeleteEquipment();

    public EquipmentMenu(MainView mainView) {
        grid.setColumns("id", "equipment", "prize");
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER,
                GridVariant.LUMO_NO_ROW_BORDERS, GridVariant.LUMO_ROW_STRIPES);

        equipment.addClickListener(event -> {
            removeEquipment.getEquipmentLayout().setVisible(false);//
            equipmentForm.setVisible(false);
            mainView.getPanelTwo().setVisible(true);
            grid.setVisible(true);
            mainView.getPanelTwo().add(grid);
            mainView.getPanelTwo().setSizeFull();
            refresh();
        });

        addEquipment.addClickListener(event -> {
            removeEquipment.getEquipmentLayout().setVisible(false);
            grid.setVisible(false);
            mainView.getPanelTwo().setVisible(true);
            equipmentForm.setVisible(true);
            equipment.focus();
            mainView.getPanelTwo().add(equipmentForm);
        });

        deleteEquipment.addClickListener(event -> {
            equipmentForm.setVisible(false);
            grid.setVisible(false);
            removeEquipment.getEquipmentLayout().setVisible(true);
            mainView.getPanelTwo().setVisible(true);
            mainView.getPanelTwo().add(removeEquipment.getEquipmentLayout());
            mainView.getPanelTwo().setSizeFull();

        });

        equipmentLayout = new VerticalLayout(
                equipment,
                addEquipment,
                deleteEquipment);
    }

    public void refresh() {
        grid.setItems(equipmentClient.getEquipments());
    }

    public VerticalLayout getEquipmentLayout() {
        return equipmentLayout;
    }

    public Grid<GetEquipmentDto> getGrid() {
        return grid;
    }

    public EquipmentForm getEquipmentForm() {
        return equipmentForm;
    }

    public DeleteEquipment getRemoveEquipment() {
        return removeEquipment;
    }
}