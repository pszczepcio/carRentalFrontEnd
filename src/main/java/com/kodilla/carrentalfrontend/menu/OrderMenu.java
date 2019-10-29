package com.kodilla.carrentalfrontend.menu;

import com.kodilla.carrentalfrontend.mainview.MainView;
import com.kodilla.carrentalfrontend.grid.OrderGrid;
import com.kodilla.carrentalfrontend.workingarea.AddOrder;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Getter;

public class OrderMenu {
    @Getter
    private VerticalLayout orderMenuLayout = new VerticalLayout();
    private Button orders = new Button("orders");
    private Button newOrder = new Button("new order");
    private MainView mainView;
    private OrderGrid orderGrid;

    public OrderMenu(MainView mainView) {
        this.mainView = mainView;
        orderGrid = new OrderGrid(mainView);
        orderMenuLayout.add(orders, newOrder);
        showOrders();
        createOrder();
    }

    private void showOrders() {
        orders.addClickListener(event -> {
            mainView.getPanelTwo().removeAll();
            mainView.getPanelTwo().add(orderGrid.getOrderDtoGrid());
            orderGrid.orderGridRefresh();
            mainView.getPanelTwo().setSizeFull();
        });
    }

    private void createOrder() {
        newOrder.addClickListener(event -> {
            mainView.getPanelTwo().removeAll();
            AddOrder addOrder = new AddOrder(mainView);
            mainView.getPanelTwo().add(addOrder.getAddOrderVerticalLayout());
            mainView.getPanelTwo().setSizeFull();
        });
    }}
