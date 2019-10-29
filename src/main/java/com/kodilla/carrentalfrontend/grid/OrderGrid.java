package com.kodilla.carrentalfrontend.grid;

import com.kodilla.carrentalfrontend.client.OrderClient;
import com.kodilla.carrentalfrontend.mainview.MainView;
import com.kodilla.carrentalfrontend.domain.OrderDto;
import com.kodilla.carrentalfrontend.form.OrderForm;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import javafx.scene.text.TextAlignment;
import lombok.Getter;

public class OrderGrid {
    private OrderClient orderClient = new OrderClient();
    @Getter
    private Grid<OrderDto> orderDtoGrid = new Grid<>(OrderDto.class);
    private MainView mainView;

    public OrderGrid(MainView mainView) {
        orderDtoGrid.setColumns(
                "id", "orderNumber", "dateOfOrder",
                "dateOfCarRental", "dateOfReturnCar",
                "statusOrder", "prize", "userId", "carId");
        orderDtoGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER,
                GridVariant.LUMO_NO_ROW_BORDERS, GridVariant.LUMO_ROW_STRIPES);
        orderDtoGrid.getColumns().get(0).setWidth("10px");
        orderDtoGrid.getColumns().get(7).setWidth("10px");
        orderDtoGrid.getColumns().get(8).setWidth("10px");
        orderDtoGrid.getColumns()
                .forEach(c->c.setTextAlign(ColumnTextAlign.valueOf(TextAlignment.CENTER.toString())));
        orderDtoGrid.getColumns()
                .forEach(c -> c.setResizable(true));
        orderGridRefresh();

        orderDtoGrid.addItemClickListener(event -> {
            OrderForm orderForm = new OrderForm(mainView, event.getItem().getId());
            mainView.getPanelTwo().removeAll();
            mainView.getPanelTwo().add(orderForm.getOrderVerticalLayout());
            mainView.getPanelTwo().setSizeFull();
        });
    }

    public void orderGridRefresh() {
        orderDtoGrid.setItems(orderClient.getOrderDtoList());
    }
}
