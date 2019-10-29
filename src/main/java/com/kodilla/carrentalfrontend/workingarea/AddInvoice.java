package com.kodilla.carrentalfrontend.workingarea;

import com.kodilla.carrentalfrontend.client.InvoiceClient;
import com.kodilla.carrentalfrontend.domain.CreateInvoiceDto;
import com.kodilla.carrentalfrontend.mainview.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import lombok.Getter;

import static com.helger.commons.string.StringParser.isLong;

public class AddInvoice {
    @Getter
    private VerticalLayout createInvoiceLayout = new VerticalLayout();
    private TextField userId = new TextField("User Id: ");
    private TextField orderId = new TextField("Order Id: ");
    private Button addInvoice = new Button("add");
    private Button cancel = new Button("cancel");
    private InvoiceClient invoiceClient = new InvoiceClient();
    private MainView mainView;

    public AddInvoice(MainView mainView) {
        this.mainView = mainView;
        createInvoiceLayout.add(
                new HorizontalLayout(userId, orderId),
                new HorizontalLayout(addInvoice, cancel));
        newInvoice();
        cancel();
    }

    private void newInvoice() {
        addInvoice.addClickListener(event -> {
            if (isLong(userId.getValue()) && isLong(orderId.getValue())) {
                invoiceClient.addInvoice(new CreateInvoiceDto(
                        Long.parseLong(userId.getValue()),
                        Long.parseLong(orderId.getValue())));
                userId.clear();
                orderId.clear();
                mainView.getPanelTwo().removeAll();
            }else {
                Notification.show("Invalid data entered.");
            }
        });
    }

    private void cancel() {
        cancel.addClickListener(event -> {
            mainView.getPanelTwo().removeAll();
            mainView.getAccordion().close();
        });
    }}
