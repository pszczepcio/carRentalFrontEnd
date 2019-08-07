package com.kodilla.carrentalfrontend.domain;

public class UpdateOrderStatus {
        private Long orderId;
        private boolean orderStatus;

    public UpdateOrderStatus() {
    }

    public UpdateOrderStatus(Long orderId, boolean orderStatus) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
    }

    public Long getOrderId() {
        return orderId;
    }

    public boolean isOrderStatus() {
        return orderStatus;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }
}
