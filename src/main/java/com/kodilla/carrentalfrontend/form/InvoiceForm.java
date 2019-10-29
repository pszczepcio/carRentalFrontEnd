package com.kodilla.carrentalfrontend.form;

import com.kodilla.carrentalfrontend.client.InvoiceClient;
import com.kodilla.carrentalfrontend.domain.InvoiceDto;
import com.kodilla.carrentalfrontend.grid.InvoiceGrid;
import com.kodilla.carrentalfrontend.mainview.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import lombok.Getter;

public class InvoiceForm {
    @Getter
    private VerticalLayout invoiceFormLayout = new VerticalLayout();
    private InvoiceClient invoiceClient = new InvoiceClient();
    private TextField id = new TextField("Id:");
    private TextField invoiceNumber= new TextField("Invoice number:");
    private TextField userId = new TextField("User id:");
    private TextField orderId= new TextField("Order id:");

    private Button deleteButton = new Button("delete");
    private Button cancelButton = new Button("cancel");
    private Long invoiceId;
    private MainView mainView;

    public InvoiceForm(MainView mainView, final Long invoiceId) {
        this.mainView = mainView;
        this.invoiceId = invoiceId;
        invoiceFormLayout.add(
                id,
                invoiceNumber,
                userId,
                orderId,
                new HorizontalLayout(deleteButton, cancelButton)
        );
        fillInAllFields();
        mainView.getPanelTwo().removeAll();
        mainView.getPanelTwo().add(invoiceFormLayout);
        mainView.getPanelTwo().setSizeFull();
        deleteInvoice();
        cancelInvoice();
    }

    private void fillInAllFields() {
        InvoiceDto invoiceDto = invoiceClient.getInvoiceDto(invoiceId);
        id.setValue(invoiceDto.getId().toString());
        invoiceNumber.setValue(invoiceDto.getInvoiceNumber());
        userId.setValue(invoiceDto.getUserId().toString());
        orderId.setValue(invoiceDto.getOrderId().toString());
    }

    private void deleteInvoice() {
        deleteButton.addClickListener(event -> {
            invoiceClient.deleteInvoice(Long.parseLong(id.getValue()));
            clearFields();
            mainView.getPanelTwo().removeAll();
            InvoiceGrid invoiceGrid = new InvoiceGrid(mainView);
            mainView.getPanelTwo().add(invoiceGrid.getInvoiceDtoGrid());
            mainView.getPanelTwo().setSizeFull();
        });
    }

    private void cancelInvoice() {
        cancelButton.addClickListener(event -> {
            clearFields();
            mainView.getPanelTwo().removeAll();
            mainView.getAccordion().close();
        });
    }

    private void clearFields() {
        id.clear();
        invoiceNumber.clear();
        userId.clear();
        orderId.clear();
    }}
