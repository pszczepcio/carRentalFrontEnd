package com.kodilla.carrentalfrontend.form;

import com.kodilla.carrentalfrontend.client.EquipmentClient;
import com.kodilla.carrentalfrontend.domain.AdditionalEquipment;
import com.kodilla.carrentalfrontend.mainview.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import lombok.Getter;

public class EquipmentForm extends FormLayout {
    @Getter
    private VerticalLayout equipmentFormLayout = new VerticalLayout();
    private HorizontalLayout buttonsLayout = new HorizontalLayout();
    private TextField equipment = new TextField("Equipment");
    private TextField prize = new TextField("Prize");
    private Button save = new Button("Save");
    private Button cancel = new Button("Cancel");
    private EquipmentClient equipmentClient = new EquipmentClient();

    public EquipmentForm(MainView mainView) {
        save.addThemeName("primary");
        buttonsLayout.add(save, cancel);
        equipmentFormLayout.add(equipment, prize, buttonsLayout);

        save.addClickListener(event -> {
            if (equipment.getValue().equals("") || prize.getValue().equals("")){
                Notification.show("Field equipment and prize must be completed");
            }else {
                equipmentClient.createEquipment(new AdditionalEquipment(
                        equipment.getValue(),
                        Integer.parseInt(prize.getValue())));
                equipment.clear();
                prize.clear();
            }
        });

        cancel.addClickListener(event -> {
            equipment.clear();
            prize.clear();
            mainView.getPanelTwo().removeAll();
            mainView.getAccordion().close();
        });
    }
}
