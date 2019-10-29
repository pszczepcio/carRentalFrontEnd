package com.kodilla.carrentalfrontend.menu;

import com.kodilla.carrentalfrontend.mainview.MainView;
import com.kodilla.carrentalfrontend.grid.InvoiceGrid;
import com.kodilla.carrentalfrontend.workingarea.AddInvoice;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Getter;

public class InvoiceMenu {
    @Getter
    private VerticalLayout invoiceLayout = new VerticalLayout();
    private Button createInvoiceButton = new Button ("create invoice");
    private Button invoices = new Button ("invoices");
    private MainView mainView;

    public InvoiceMenu(MainView mainView) {
        this.mainView = mainView;
        invoiceLayout.add(invoices, createInvoiceButton);
        newInvoice();
        showInvoices();
    }

    private void newInvoice() {
        createInvoiceButton.addClickListener(event -> {
            AddInvoice addInvoice = new AddInvoice(mainView);
            mainView.getPanelTwo().removeAll();
            mainView.getPanelTwo().add(addInvoice.getCreateInvoiceLayout());
            mainView.getPanelTwo().setSizeFull();
        });
    }

    private void showInvoices() {
        invoices.addClickListener(event -> {
            InvoiceGrid invoiceGrid = new InvoiceGrid(mainView);
            mainView.getPanelTwo().removeAll();
            mainView.getPanelTwo().add(invoiceGrid.getInvoiceDtoGrid());
            mainView.getPanelTwo().setSizeFull();
        });
    }
}
