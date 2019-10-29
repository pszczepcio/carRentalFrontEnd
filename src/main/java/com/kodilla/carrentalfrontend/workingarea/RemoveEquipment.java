package com.kodilla.carrentalfrontend.workingarea;

import com.kodilla.carrentalfrontend.client.EquipmentClient;
import com.kodilla.carrentalfrontend.mainview.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import lombok.Getter;

@Getter
public class RemoveEquipment {
    private EquipmentClient equipmentClient = new EquipmentClient();
    private VerticalLayout removeEquipmentLayout = new VerticalLayout();
    private HorizontalLayout removeButtonsLayout = new HorizontalLayout();
    private TextField equipmentId = new TextField("Equipment Id: ");
    private Button deleteEquipment = new Button("delete");
    private Button cancelDelete = new Button("cancel");

    public RemoveEquipment(MainView mainView) {
        deleteEquipment.setThemeName("primary");
        removeButtonsLayout.add(deleteEquipment, cancelDelete);
        removeEquipmentLayout.add(equipmentId, removeButtonsLayout);

        deleteEquipment.addClickListener(event -> {
            try {
                equipmentClient.deleteEquipment(Long.parseLong(equipmentId.getValue()));
                equipmentId.clear();
            }catch (NumberFormatException e) {
                Notification.show("A number must be provided in \" Equipment Id \"");
            }
        });
        cancelDelete.addClickListener(event -> {
            equipmentId.clear();
            mainView.getPanelTwo().removeAll();
            mainView.getAccordion().close();
        });
    }}
