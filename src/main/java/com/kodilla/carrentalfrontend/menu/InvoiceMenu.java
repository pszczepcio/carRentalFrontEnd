package com.kodilla.carrentalfrontend.menu;

import com.kodilla.carrentalfrontend.domain.MainView;
import com.kodilla.carrentalfrontend.grid.InvoiceGrid;
import com.kodilla.carrentalfrontend.workingarea.AddInvoice;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class InvoiceMenu {
    private Button createInvoiceButton = new Button("Create invoice");
    private Button invoicesButton = new Button("Invoices");
    private VerticalLayout invoice = new VerticalLayout();
    private AddInvoice addInvoice = new AddInvoice();
    private InvoiceGrid invoiceGrid;

    public InvoiceMenu(MainView mainView) {
        invoiceGrid = new InvoiceGrid(mainView);
        createInvoiceButton.addClickListener(event -> {
//            invoiceGrid.getInvoiceDtoGrid().setVisible(false);
//            invoiceGrid.getInvoiceForm().getInvoiceVerticalLayout().setVisible(false);
            addInvoice.getInvoiceVericalLayout().setVisible(true);
            mainView.getPanelTwo().add(addInvoice.getInvoiceVericalLayout());
            mainView.getPanelTwo().setVisible(true);
            mainView.getPanelTwo().setSizeFull();
        });

        invoicesButton.addClickListener(event -> {
            addInvoice.getInvoiceVericalLayout().setVisible(false);
            mainView.getPanelTwo().setVisible(true);
            invoiceGrid.getInvoiceDtoGrid().setVisible(true);
            mainView.getPanelTwo().add(invoiceGrid.getInvoiceDtoGrid());
            mainView.getPanelTwo().setSizeFull();
            invoiceGrid.invoicesRefresh();
        });
        invoice.add(createInvoiceButton, invoicesButton);
    }

    public VerticalLayout getInvoiceButtons() {
        return invoice;
    }

    public InvoiceGrid getInvoiceGrid() {
        return invoiceGrid;
    }

    public void closeInvoiceForm(){
        try {
            getInvoiceGrid().getInvoiceForm().getInvoiceVerticalLayout().setVisible(false);
        }catch (NullPointerException e) {

        }
    }

    public AddInvoice getAddInvoice() {
        return addInvoice;
    }
}
