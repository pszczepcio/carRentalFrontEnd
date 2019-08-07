package com.kodilla.carrentalfrontend.domain;

import com.kodilla.carrentalfrontend.form.EquipmentForm;
import com.kodilla.carrentalfrontend.grid.CarGrid;
import com.kodilla.carrentalfrontend.menu.*;
import com.kodilla.carrentalfrontend.workingarea.AddInvoice;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends HorizontalLayout{
private SignUp signUp = new SignUp(this);
private EquipmentMenu equipmentMenu = new EquipmentMenu(this);
private EquipmentForm equipmentForm = new EquipmentForm();
private CarMenu carMenu = new CarMenu(this);
private OrderMenu orderMenu = new OrderMenu(this);
private InvoiceMenu invoiceMenu = new InvoiceMenu(this);
private AddInvoice addInvoice = new AddInvoice();
private UsersMenu usersMenu = new UsersMenu(this);


private HorizontalLayout panelOne = new HorizontalLayout();
private HorizontalLayout panelTwo = new HorizontalLayout();
private CarGrid carGrid = new CarGrid(this);
private Accordion accordion = new Accordion();

    public MainView() {
        accordion.close();
        accordion.add("Users", usersMenu.getUserLayout());
        accordion.add("Sign Up", signUp.getCreateUserLayout());
        accordion.add("Equipment", equipmentMenu.getEquipmentLayout());
        accordion.add("Cars", carMenu.getCarLayout());
        accordion.add("Orders", orderMenu.getOrderLayout());
        accordion.add("Invoices", invoiceMenu.getInvoiceButtons());
        panelOne.add(accordion);
        accordion.addOpenedChangeListener(event -> {
            equipmentMenu.getRemoveEquipment().getEquipmentLayout().setVisible(false);
            invoiceMenu.getAddInvoice().getInvoiceVericalLayout().setVisible(false);
            orderMenu.closeAddOrder();
            orderMenu.getDeleteOrder().getOrdertLayout().setVisible(false);
            carMenu.getReturningCar().getReturnLayout().setVisible(false);
            equipmentMenu.getEquipmentForm().setVisible(false);
            usersMenu.getUserGrid().getUserDtoListGrid().setVisible(false);
            invoiceMenu.getInvoiceGrid().getInvoiceDtoGrid().setVisible(false);
            invoiceMenu.closeInvoiceForm();
            addInvoice.getInvoiceVericalLayout().setVisible(false);
            orderMenu.closeOrderFoam();
            orderMenu.getOrderGrid().getOrderDtoGrid().setVisible(false);
            panelTwo.setVisible(false);
            carMenu.getAddCar().getCreateCarLayout().setVisible(false);
            carMenu.getCarsGrid().getCarGrid().setVisible(false);
            carMenu.getCarsGrid().getCarVerticalLayout().setVisible(false);
            equipmentMenu.getGrid().setVisible(false);
            equipmentForm.getTextfieldsLayout().setVisible(false);
            equipmentForm.setVisible(false);
            carGrid.getCarVerticalLayout().setVisible(false);
        });
        add(panelOne, panelTwo);
    }

    public HorizontalLayout getPanelTwo() {
        return panelTwo;
    }

    public void setPanelTwo(HorizontalLayout panelTwo) {
        this.panelTwo = panelTwo;
    }

    public HorizontalLayout getPanelOne() {
        return panelOne;
    }

    public void setPanelOne(HorizontalLayout panelOne) {
        this.panelOne = panelOne;
    }

    public Accordion getAccordion() {
        return accordion;
    }

}
