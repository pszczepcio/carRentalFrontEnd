package com.kodilla.carrentalfrontend.workingarea;

import com.kodilla.carrentalfrontend.client.OrderClient;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class DeleteOrder {
    private VerticalLayout ordertLayout = new VerticalLayout();
    private TextField ordertId = new TextField("Order Id:");
    private Button deleteOrder = new Button("delete");
    private OrderClient orderClient = new OrderClient();

    public DeleteOrder() {
        ordertLayout.add(ordertId, deleteOrder);
        deleteOrder.addClickListener(event -> {
            orderClient.deleteOrder(Long.parseLong(ordertId.getValue()));
            ordertLayout.setVisible(false);
        });
    }

    public VerticalLayout getOrdertLayout() {
        return ordertLayout;
    }
}
