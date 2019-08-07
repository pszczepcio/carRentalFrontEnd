package com.kodilla.carrentalfrontend.grid;

import com.kodilla.carrentalfrontend.client.InvoiceClient;
import com.kodilla.carrentalfrontend.domain.GetInvoiceDto;
import com.kodilla.carrentalfrontend.domain.MainView;
import com.kodilla.carrentalfrontend.form.InvoiceForm;
import com.kodilla.carrentalfrontend.workingarea.AddInvoice;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;

public class InvoiceGrid {
    private Grid<GetInvoiceDto> invoiceDtoGrid = new Grid<>(GetInvoiceDto.class);
    private InvoiceClient invoiceClient = new InvoiceClient();
    private AddInvoice addInvoice = new AddInvoice();
    private InvoiceForm invoiceForm;

    public InvoiceGrid(MainView mainView) {
        invoiceDtoGrid.setColumns("id", "invoiceNumber");
        invoiceDtoGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER,
                GridVariant.LUMO_NO_ROW_BORDERS, GridVariant.LUMO_ROW_STRIPES);
        invoiceDtoGrid.addItemClickListener(event -> {
            addInvoice.getInvoiceVericalLayout().setVisible(false);
            invoiceForm = new InvoiceForm(event.getItem().getId());
            invoiceForm.getInvoiceVerticalLayout().setVisible(true);
            mainView.getPanelTwo().add(invoiceForm.getInvoiceVerticalLayout());
            mainView.getPanelTwo().setVisible(true);
            mainView.getPanelTwo().setSizeFull();
            invoicesRefresh();
        });
    }

    public Grid<GetInvoiceDto> getInvoiceDtoGrid() {
        return invoiceDtoGrid;
    }

    public void invoicesRefresh() {
        invoiceDtoGrid.setItems(invoiceClient.getInvoiceDtoList());
    }

    public InvoiceForm getInvoiceForm() {
        return invoiceForm;
    }
}
