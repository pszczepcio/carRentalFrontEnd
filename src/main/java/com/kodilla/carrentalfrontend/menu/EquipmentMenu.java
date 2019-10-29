package com.kodilla.carrentalfrontend.menu;

import com.kodilla.carrentalfrontend.client.EquipmentClient;
import com.kodilla.carrentalfrontend.grid.EquipmentGrid;
import com.kodilla.carrentalfrontend.mainview.MainView;
import com.kodilla.carrentalfrontend.form.EquipmentForm;
import com.kodilla.carrentalfrontend.workingarea.RemoveEquipment;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Getter;

@Getter
public class EquipmentMenu {
    private EquipmentClient equipmentClient = new EquipmentClient();
    private EquipmentGrid equipmentGrid = new EquipmentGrid();
    private Button show = new Button("show");
    private Button add = new Button("add");
    private Button delete = new Button("delete");
    private VerticalLayout equipmentLayout = new VerticalLayout();

    public EquipmentMenu(MainView mainView) {
        equipmentLayout.add(show, add, delete);
        EquipmentForm equipmentForm = new EquipmentForm(mainView);

        show.addClickListener(event -> {
            mainView.getPanelTwo().removeAll();
            equipmentGrid.getGetEquipmentDtoGrid().setVisible(true);
            mainView.getPanelTwo().add(equipmentGrid.getGetEquipmentDtoGrid());
            mainView.getPanelTwo().setSizeFull();
            equipmentGrid.equipmentListRefresh();
        });

        add.addClickListener(event -> {

            mainView.getPanelTwo().removeAll();
            mainView.getPanelTwo().add(equipmentForm.getEquipmentFormLayout());
            mainView.getPanelTwo().setSizeFull();
        });

        delete.addClickListener(event -> {
            RemoveEquipment removeEquipment = new RemoveEquipment(mainView);
            mainView.getPanelTwo().removeAll();
            mainView.getPanelTwo().add(removeEquipment.getRemoveEquipmentLayout());
            mainView.getPanelTwo().setSizeFull();
        });
    }
}