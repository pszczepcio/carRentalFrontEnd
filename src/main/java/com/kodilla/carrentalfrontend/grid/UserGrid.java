package com.kodilla.carrentalfrontend.grid;

import com.kodilla.carrentalfrontend.client.UserClient;
import com.kodilla.carrentalfrontend.domain.UserDtoList;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import lombok.Getter;

@Getter
public class UserGrid {
    private UserClient userClient = new UserClient();
    private Grid<UserDtoList> userDtoListGrid = new Grid<>(UserDtoList.class);

    public UserGrid() {
        userDtoListGrid.setColumns("id", "name", "surname", "phone",
                "email", "loginStatus");
        userDtoListGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER,
                GridVariant.LUMO_NO_ROW_BORDERS, GridVariant.LUMO_ROW_STRIPES);
        userRefresh();
    }

    public void userRefresh() {
        userDtoListGrid.setItems(userClient.getUsers());
    }
}
