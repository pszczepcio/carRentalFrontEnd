package com.kodilla.carrentalfrontend.form;

import com.kodilla.carrentalfrontend.StatusOrder;
import com.kodilla.carrentalfrontend.client.OrderClient;
import com.kodilla.carrentalfrontend.domain.OrderDto;
import com.kodilla.carrentalfrontend.domain.UpdateOrderStatus;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;


public class OrderForm {
    private VerticalLayout orderVerticalLayout = new VerticalLayout();
    private OrderClient orderClient = new OrderClient();

    public OrderForm() {
    }

    public OrderForm(final Long orderId) {
        TextField id = new TextField("id");
        TextField numberOfOrder = new TextField("Order number");
        TextField dateOfOrder = new TextField("Date of order");
        TextField dateOfCarRental = new TextField("Date of car rental");
        TextField dateOfCarReturn = new TextField("Date of car return");
        ComboBox<StatusOrder> orderStatus = new ComboBox<>("Order status");
        TextField prize = new TextField("Prize");
        TextField userId = new TextField("User id");
        TextField carId = new TextField("Car id");

        Button deleteOrderButton = new Button("delete");
        Button updateStatusOrderButton = new Button("update status");

        HorizontalLayout orderFormHorizontalOne = new HorizontalLayout(id, numberOfOrder, dateOfOrder);
        HorizontalLayout orderFormHorizontalTwo = new HorizontalLayout(dateOfCarRental, dateOfCarReturn, orderStatus);
        HorizontalLayout orderFormHorizontalThree = new HorizontalLayout(prize, userId, carId);
        HorizontalLayout orderFormHorizontalFour = new HorizontalLayout(deleteOrderButton, updateStatusOrderButton);

        orderVerticalLayout.add(orderFormHorizontalOne, orderFormHorizontalTwo,
                orderFormHorizontalThree, orderFormHorizontalFour);

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
        }else {

            orderStatus.setItems(StatusOrder.COMPLETED, StatusOrder.NOT_COMPLETED);
        }

        deleteOrderButton.addClickListener(event -> {
            orderClient.deleteOrder(orderId);
            orderVerticalLayout.setVisible(false);
        });

        updateStatusOrderButton.addClickListener(event -> {
            UpdateOrderStatus updateOrderStatus = new UpdateOrderStatus();
            if (orderStatus.getValue().equals(StatusOrder.COMPLETED)){
                updateOrderStatus.setOrderStatus(true);
            } else if (orderStatus.getValue().equals(StatusOrder.NOT_COMPLETED)){
                updateOrderStatus.setOrderStatus(false);
            }
            updateOrderStatus.setOrderId(orderId);
            orderClient.updateStatus(updateOrderStatus);
            orderVerticalLayout.setVisible(false);
        });
    }

    public VerticalLayout getOrderVerticalLayout() {
        return orderVerticalLayout;
    }
}
