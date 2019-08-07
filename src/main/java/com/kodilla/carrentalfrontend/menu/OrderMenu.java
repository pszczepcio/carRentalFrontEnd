package com.kodilla.carrentalfrontend.menu;

import com.kodilla.carrentalfrontend.client.EquipmentClient;
import com.kodilla.carrentalfrontend.client.OrderClient;
import com.kodilla.carrentalfrontend.domain.MainView;
import com.kodilla.carrentalfrontend.grid.OrderGrid;
import com.kodilla.carrentalfrontend.workingarea.AddOrder;
import com.kodilla.carrentalfrontend.workingarea.DeleteOrder;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class OrderMenu {
    private Button orders = new Button("orders");
    private Button addOrders = new Button("new order");
    private Button deleteOrders = new Button("delete order");
    private VerticalLayout orderLayout = new VerticalLayout();
    private OrderGrid orderGrid;
    private OrderClient orderClient = new OrderClient();
    private AddOrder addOrder;
    private EquipmentClient equipmentClient = new EquipmentClient();
    private EquipmentMenu equipmentMenu;
    private DeleteOrder deleteOrder = new DeleteOrder();

    public OrderMenu(MainView mainView) {
        orderGrid = new OrderGrid(mainView);
        orders.addClickListener(event -> {
            deleteOrder.getOrdertLayout().setVisible(false);
            orderGrid.getOrderDtoGrid().setVisible(true);
            mainView.getPanelTwo().setVisible(true);
            mainView.getPanelTwo().add(orderGrid.getOrderDtoGrid());
            mainView.getPanelTwo().setSizeFull();
            orderGrid.ordersRefresh();
            closeOrderFoam();
            orderGrid.getOrderDtoGrid().addItemClickListener(event1 -> {
                orderGrid.getOrderDtoGrid().setVisible(false);
                orderClient.getOrderDto(event1.getItem().getId());
            });
        });

        addOrders.addClickListener(event -> {
            deleteOrder.getOrdertLayout().setVisible(false);
            equipmentMenu= new EquipmentMenu(mainView);
            addOrder = new AddOrder(equipmentClient.getEquipments());
            orderGrid.getOrderDtoGrid().setVisible(false);
            closeOrderFoam();
            addOrder.getAddOrderVerticalLayout().setVisible(true);
            mainView.getPanelTwo().add(addOrder.getAddOrderVerticalLayout());
            mainView.getPanelTwo().setVisible(true);
            mainView.setSizeFull();
        });

        deleteOrders.addClickListener(event -> {
            orderGrid.getOrderDtoGrid().setVisible(false);
            deleteOrder.getOrdertLayout().setVisible(true);
            mainView.getPanelTwo().setVisible(true);
            mainView.getPanelTwo().add(deleteOrder.getOrdertLayout());
            mainView.getPanelTwo().setSizeFull();
           ;
        });

        orderLayout.add(orders, addOrders, deleteOrders);
    }

    public VerticalLayout getOrderLayout() {
        return orderLayout;
    }

    public OrderGrid getOrderGrid() {
        return orderGrid;
    }

    public void closeOrderFoam(){
        try {
            orderGrid.getOrderForm().getOrderVerticalLayout().setVisible(false);
        }catch (NullPointerException e){
        }
    }

    public void closeAddOrder() {
        try {
            addOrder.getAddOrderVerticalLayout().setVisible(false);
        }catch (NullPointerException e){

        }
    }
    public AddOrder getAddOrder() {
        return addOrder;
    }

    public DeleteOrder getDeleteOrder() {
        return deleteOrder;
    }
}
