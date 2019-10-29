package com.kodilla.carrentalfrontend.grid;

import com.kodilla.carrentalfrontend.client.InvoiceClient;
import com.kodilla.carrentalfrontend.domain.GetInvoiceDto;
import com.kodilla.carrentalfrontend.mainview.MainView;
import com.kodilla.carrentalfrontend.form.InvoiceForm;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import lombok.Getter;

public class InvoiceGrid {
    @Getter
    private Grid<GetInvoiceDto> invoiceDtoGrid = new Grid<>(GetInvoiceDto.class);
    private InvoiceClient invoiceClient = new InvoiceClient();
    private MainView mainView;

    public InvoiceGrid(MainView mainView) {
        this.mainView = mainView;
        invoiceDtoGrid.setColumns("id", "invoiceNumber");
        invoiceDtoGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER,
                GridVariant.LUMO_NO_ROW_BORDERS, GridVariant.LUMO_ROW_STRIPES);
        invoiceGridRefresh();
        showInvoiceForm();
    }

    public void invoiceGridRefresh() {
        invoiceDtoGrid.setItems(invoiceClient.getInvoiceDtoList());
    }

    private void showInvoiceForm(){
        invoiceDtoGrid.addItemClickListener(event -> {
            new InvoiceForm(mainView, event.getItem().getId());
        });
    }}
