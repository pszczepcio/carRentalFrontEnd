package com.kodilla.carrentalfrontend.workingarea;

import com.kodilla.carrentalfrontend.client.InvoiceClient;
import com.kodilla.carrentalfrontend.domain.CreateInvoiceDto;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class AddInvoice {
    private TextField user = new TextField("User Id:");
    private TextField order = new TextField("Order id:");
    private HorizontalLayout addInvoiceData = new HorizontalLayout();
    private Button addInvoice = new Button("Add");
    private Button cancel = new Button("Cancel");
    private HorizontalLayout invoiceButtons = new HorizontalLayout();
    private VerticalLayout invoiceVerticalLayout = new VerticalLayout();
    private InvoiceClient invoiceClient = new InvoiceClient();

    public AddInvoice() {
        addInvoiceData.add(user, order);
        invoiceButtons.add(addInvoice, cancel);
        invoiceVerticalLayout.add(addInvoiceData, invoiceButtons);
        addInvoice.addClickListener(event -> {
            CreateInvoiceDto createInvoiceDto = new CreateInvoiceDto(
                    Long.parseLong(user.getValue()),
                    Long.parseLong(order.getValue()));
            invoiceClient.addInvoice(createInvoiceDto);
            user.clear();
            order.clear();
            invoiceVerticalLayout.setVisible(false);
        });
        cancel.addClickListener(event -> {
            user.clear();
            order.clear();
            invoiceVerticalLayout.setVisible(false);
        });
    }

    public VerticalLayout getInvoiceVericalLayout() {
        return invoiceVerticalLayout;
    }
}
