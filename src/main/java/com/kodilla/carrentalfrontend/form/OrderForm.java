package com.kodilla.carrentalfrontend.form;

import com.kodilla.carrentalfrontend.StatusOrder;
import com.kodilla.carrentalfrontend.client.OrderClient;
import com.kodilla.carrentalfrontend.domain.OrderDto;
import com.kodilla.carrentalfrontend.domain.UpdateOrderStatus;
import com.kodilla.carrentalfrontend.mainview.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import lombok.Getter;


public class OrderForm {
    @Getter
    private VerticalLayout orderVerticalLayout = new VerticalLayout();
    private OrderClient orderClient = new OrderClient();
    private TextField id = new TextField("id");
    private TextField numberOfOrder = new TextField("Order number");
    private TextField dateOfOrder = new TextField("Date of order");
    private TextField dateOfCarRental = new TextField("Date of car rental");
    private TextField dateOfCarReturn = new TextField("Date of car return");
    private ComboBox<StatusOrder> orderStatus = new ComboBox<>("Order status");
    private TextField prize = new TextField("Prize");
    private TextField userId = new TextField("User id");
    private TextField carId = new TextField("Car id");
    private Long orderId;
    private Button deleteOrderButton = new Button("delete");
    private Button updateStatusOrderButton = new Button("update status");
    private MainView mainView;

    public OrderForm(MainView mainView, final Long orderId) {
        this.orderId = orderId;
        this.mainView = mainView;
        orderVerticalLayout.add(
                new HorizontalLayout(id, numberOfOrder, dateOfOrder),
                new HorizontalLayout(dateOfCarRental, dateOfCarReturn, orderStatus),
                new HorizontalLayout(prize, userId, carId),
                new HorizontalLayout(deleteOrderButton, updateStatusOrderButton));
        showOrder(orderId);
        updateStatusOrder();
        deleteOrder();
    }

    private OrderDto showOrder(final Long orderId) {
        OrderDto orderDto = orderClient.getOrderDto(orderId);
        id.setValue(orderDto.getId().toString());
        numberOfOrder.setValue(orderDto.getOrderNumber());
        dateOfOrder.setValue(orderDto.getDateOfOrder().toString());
        dateOfCarRental.setValue(orderDto.getDateOfCarRental().toString());
        dateOfCarReturn.setValue(orderDto.getDateOfReturnCar().toString());
        prize.setValue(Double.toString(orderDto.getPrize()));
        userId.setValue(Long.toString(orderDto.getUserId()));
        carId.setValue(Long.toString(orderDto.getCarId()));
        if (orderDto.isStatusOrder()) {
            orderStatus.setItems(StatusOrder.COMPLETED, StatusOrder.NOT_COMPLETED);
            orderStatus.setValue(StatusOrder.COMPLETED);
        }else {
            orderStatus.setItems(StatusOrder.COMPLETED, StatusOrder.NOT_COMPLETED);
            orderStatus.setValue(StatusOrder.NOT_COMPLETED);
        }
        return orderDto;
    }

    private void updateStatusOrder() {
        updateStatusOrderButton.addClickListener(event -> {
            UpdateOrderStatus updateOrderStatus = new UpdateOrderStatus();
            if (orderStatus.getValue().equals(StatusOrder.COMPLETED)){
                updateOrderStatus.setOrderStatus(true);
            } else if (orderStatus.getValue().equals(StatusOrder.NOT_COMPLETED)){
                updateOrderStatus.setOrderStatus(false);
            }
            updateOrderStatus.setOrderId(orderId);
            orderClient.updateStatus(updateOrderStatus);
            mainView.getPanelTwo().removeAll();
        });
    }
    private void deleteOrder() {
        deleteOrderButton.addClickListener(event -> {
            orderClient.deleteOrder(orderId);
            mainView.getPanelTwo().removeAll();
            mainView.getAccordion().close();
        });
    }}
