package com.kodilla.carrentalfrontend.mainview;

import com.kodilla.carrentalfrontend.menu.*;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends AppLayout {
    private UsersMenu userMenu = new UsersMenu(this);
    private EquipmentMenu equipmentMenu = new EquipmentMenu(this);
    private CarMenu carMenu = new CarMenu(this);
    private OrderMenu orderMenu = new OrderMenu(this);
    private InvoiceMenu invoiceMenu = new InvoiceMenu(this);
    private HorizontalLayout panelOne = new HorizontalLayout();
    private HorizontalLayout panelTwo = new HorizontalLayout();
    private Accordion accordion = new Accordion();

    public MainView() {
        setMenu();
        setMainView();

    }

    public HorizontalLayout getPanelTwo() {
        return panelTwo;
    }

    public Accordion getAccordion() {
        return accordion;
    }

    private void setMenu(){
        Label label = new Label("CAR RENTAL APP");
        label.setHeight("100px");
        setMenu(label);
    }

    private Accordion setAccordion() {
        accordion.add("Users", userMenu.getUserLayout());
        accordion.add("Equipments", (equipmentMenu.getEquipmentLayout()));
        accordion.add("Cars", (carMenu.getCarMenuLayout()));
        accordion.add("Orders", (orderMenu.getOrderMenuLayout()));
        accordion.add("Invoices", (invoiceMenu.getInvoiceLayout()));
        accordion.addOpenedChangeListener(event -> panelTwo.removeAll());
        accordion.close();
        return accordion;
    }

    private void setMainView() {
        panelOne.add(setAccordion());
        setContent(new HorizontalLayout(panelOne, panelTwo));
    }
}
