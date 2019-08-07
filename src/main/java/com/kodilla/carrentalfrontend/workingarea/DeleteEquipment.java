package com.kodilla.carrentalfrontend.workingarea;

import com.kodilla.carrentalfrontend.client.EquipmentClient;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class DeleteEquipment {
    private VerticalLayout equipmentLayout = new VerticalLayout();
    private TextField equipmentId = new TextField("Equipment Id:");
    private Button deleteEquipment = new Button("delete");
    private EquipmentClient equipmentClient = new EquipmentClient();

    public DeleteEquipment() {
        equipmentLayout.add(equipmentId, deleteEquipment);
        deleteEquipment.addClickListener(event -> {
            equipmentClient.deleteEquipment(Long.parseLong(equipmentId.getValue()));
            equipmentLayout.setVisible(false);
        });
    }

    public VerticalLayout getEquipmentLayout() {
        return equipmentLayout;
    }
}
