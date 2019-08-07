package com.kodilla.carrentalfrontend.form;

import com.kodilla.carrentalfrontend.client.InvoiceClient;
import com.kodilla.carrentalfrontend.domain.InvoiceDto;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class InvoiceForm {
    private VerticalLayout invoiceVerticalLayout = new VerticalLayout();
    private InvoiceClient invoiceClient = new InvoiceClient();

    public InvoiceForm(final Long invoiceId) {
        TextField id = new TextField("Id:");
        TextField invoiceNumber= new TextField("Invoice number:");
        TextField userId = new TextField("User id:");
        TextField orderId= new TextField("Order id:");

        Button deleteButton = new Button("Delete");
        Button cancelButton = new Button("Cancel");
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.add(deleteButton, cancelButton);

        invoiceVerticalLayout.add(id, invoiceNumber,
                userId, orderId, horizontalLayout);

        InvoiceDto invoiceDto = invoiceClient.getInvoiceDto(invoiceId);
        id.setValue(invoiceDto.getId().toString());
        invoiceNumber.setValue(invoiceDto.getInvoiceNumber());
        userId.setValue(invoiceDto.getUserId().toString());
        orderId.setValue(invoiceDto.getOrderId().toString());

        deleteButton.addClickListener(event -> {
            id.clear();
            invoiceNumber.clear();
            userId.clear();
            orderId.clear();
            invoiceVerticalLayout.setVisible(false);
            invoiceClient.deleteInvoice(invoiceId);
        });

        cancelButton.addClickListener(event -> {
            invoiceVerticalLayout.setVisible(false);
            id.clear();
            invoiceNumber.clear();
            userId.clear();
            orderId.clear();
        });
    }

    public VerticalLayout getInvoiceVerticalLayout() {
        return invoiceVerticalLayout;
    }
}
