package com.kodilla.carrentalfrontend.grid;

import com.kodilla.carrentalfrontend.client.UserClient;
import com.kodilla.carrentalfrontend.domain.MainView;
import com.kodilla.carrentalfrontend.dto.UserDtoList;
import com.kodilla.carrentalfrontend.form.UserForm;
import com.kodilla.carrentalfrontend.form.UserFormTwo;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class UserGrid {
    private Grid<UserDtoList> userDtoListGrid = new Grid<>(UserDtoList.class);
    private UserClient userClient = new UserClient();
    private UserFormTwo userForm;
    private VerticalLayout carVerticalLayout = new VerticalLayout();

    public UserGrid(MainView mainView) {
        userDtoListGrid.setColumns("id", "name", "surname", "phone",
                "email", "loginStatus");
        userDtoListGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER,
                GridVariant.LUMO_NO_ROW_BORDERS, GridVariant.LUMO_ROW_STRIPES);

        userDtoListGrid.addItemClickListener(event -> {
            userForm = new UserFormTwo(event.getItem().getId());
            userDtoListGrid.setVisible(false);
            mainView.getPanelTwo().add(userForm.getUserLayout());
            mainView.getPanelTwo().setVisible(true);
            userForm.getUserLayout().setVisible(true);
        });
    }

    public void userRefresh(){
        userDtoListGrid.setItems(userClient.getCars());
    }

    public Grid<UserDtoList> getUserDtoListGrid() {
        return userDtoListGrid;
    }
}
