package com.kodilla.carrentalfrontend.form;

import com.kodilla.carrentalfrontend.client.UserClient;
import com.kodilla.carrentalfrontend.dto.UserDto;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class UserFormTwo {
    private VerticalLayout userLayout = new VerticalLayout();
    private UserClient userClient = new UserClient();
    private UserDto userDto;

    public UserFormTwo(Long eventUserId) {
        TextField id = new TextField("Id:");
        TextField name = new TextField("Name:");
        TextField surname = new TextField("Surnmae:");
        TextField phone = new TextField("Phone:");
        TextField email = new TextField("Email:");
        TextField status = new TextField("status:");
        TextField orderIdList = new TextField("Order id list:");
        TextField invoiceIdList = new TextField("Invoice id list:");
        Button deleteUser = new Button("Delete");

        userLayout.add(id, name, surname, phone, email, status, orderIdList, invoiceIdList,deleteUser);
        userDto = userClient.getUser(eventUserId);
        id.setValue(userDto.getId().toString());
        name.setValue(userDto.getName());
        surname.setValue(userDto.getSurname());
        phone.setValue(Integer.toString(userDto.getPhone()));
        email.setValue(userDto.getEmail());
        status.setValue(Boolean.toString(userDto.isLoginStatus()));
        int orderSize = userDto.getOrderIdList().size();
        int invoiceSize = userDto.getInvoiceIdList().size();
        String orders = " ";
        String invoices = " ";
        if (orderSize != 0){
            for (int i = 0 ; i < orderSize ; i++){
                orders = userDto.getOrderIdList().get(i).toString() + ", ";
            }
            orderIdList.setValue(orders);
        }

        if (invoiceSize != 0){
            for (int i = 0 ; i < invoiceSize ; i++){
                invoices = userDto.getInvoiceIdList().get(i).toString() + ", ";
            }
            invoiceIdList.setValue(invoices);
        }

        deleteUser.addClickListener(event -> {
            userClient.deleteUser(eventUserId);
            userLayout.setVisible(false);
        });
    }

    public VerticalLayout getUserLayout() {
        return userLayout;
    }
}
