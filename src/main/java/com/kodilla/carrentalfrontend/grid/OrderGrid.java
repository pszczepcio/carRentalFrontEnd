package com.kodilla.carrentalfrontend.grid;

import com.kodilla.carrentalfrontend.client.EquipmentClient;
import com.kodilla.carrentalfrontend.client.OrderClient;
import com.kodilla.carrentalfrontend.domain.MainView;
import com.kodilla.carrentalfrontend.domain.OrderDto;
import com.kodilla.carrentalfrontend.form.OrderForm;
import com.kodilla.carrentalfrontend.workingarea.AddOrder;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import javafx.scene.text.TextAlignment;

public class OrderGrid {
    private Grid<OrderDto> ordersDtoGrid = new Grid<>(OrderDto.class);
    private OrderClient orderClient = new OrderClient();
    private EquipmentClient equipmentClient = new EquipmentClient();
    private AddOrder addOrder = new AddOrder(equipmentClient.getEquipments());
    private OrderForm orderForm;

    public OrderGrid(MainView mainView) {
        ordersDtoGrid.setColumns("id", "orderNumber", "dateOfOrder",
                 "dateOfCarRental", "dateOfReturnCar",
         "statusOrder", "prize", "userId", "carId");
        ordersDtoGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER,
                GridVariant.LUMO_NO_ROW_BORDERS, GridVariant.LUMO_ROW_STRIPES);
        ordersDtoGrid.getColumns().get(0).setWidth("10px");
        ordersDtoGrid.getColumns().get(7).setWidth("10px");
        ordersDtoGrid.getColumns().get(8).setWidth("10px");
        ordersDtoGrid.getColumns()
                .forEach(c->c.setTextAlign(ColumnTextAlign.valueOf(TextAlignment.CENTER.toString())));
        ordersDtoGrid.getColumns()
                .forEach(c -> c.setResizable(true));

        ordersDtoGrid.addItemClickListener(event -> {
            addOrder.getAddOrderVerticalLayout().setVisible(false);
            orderForm = new OrderForm(event.getItem().getId());
            ordersDtoGrid.setVisible(false);
            mainView.getPanelTwo().add(orderForm.getOrderVerticalLayout());
            mainView.getPanelTwo().setVisible(true);
            orderForm.getOrderVerticalLayout().setVisible(true);
        });
    }

    public void ordersRefresh() {
        ordersDtoGrid.setItems(orderClient.getOrderDtoList());
    }

    public Grid<OrderDto> getOrderDtoGrid() {
        return ordersDtoGrid;
    }

    public OrderForm getOrderForm() {
        return orderForm;
    }
}
