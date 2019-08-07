package com.kodilla.carrentalfrontend.form;


import com.kodilla.carrentalfrontend.client.EquipmentClient;
import com.kodilla.carrentalfrontend.domain.AdditionalEquipment;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;


public class EquipmentForm extends FormLayout {
    VerticalLayout textfieldsLayout = new VerticalLayout();
    private TextField equipment = new TextField("Equipment: ");
    private TextField prize = new TextField("Prize: ");
    private Button save = new Button("save");
    private Button cancel = new Button("cancel");
    private HorizontalLayout buttons;
    private EquipmentClient equipmentClient = new EquipmentClient();

    public EquipmentForm() {
        save.addThemeName("primary");
        textfieldsLayout.add(equipment, prize);
        buttons = new HorizontalLayout(save, cancel);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(textfieldsLayout,buttons);

        save.addClickListener(event -> {
            AdditionalEquipment additionalEquipment = new AdditionalEquipment();
            additionalEquipment.setEquipment(equipment.getValue());
            additionalEquipment.setPrize(Integer.parseInt(prize.getValue()));
            equipmentClient.createEquipment(additionalEquipment);
            equipment.clear();
            prize.clear();
            setVisible(false);
        });

        cancel.addClickListener(event -> setVisible(false));
    }

    public HorizontalLayout getButtons() {
        return buttons;
    }

    public VerticalLayout getTextfieldsLayout() {
        return textfieldsLayout;
    }
}
