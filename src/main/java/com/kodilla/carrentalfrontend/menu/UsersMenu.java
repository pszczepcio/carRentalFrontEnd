package com.kodilla.carrentalfrontend.menu;

import com.kodilla.carrentalfrontend.mainview.MainView;
import com.kodilla.carrentalfrontend.grid.UserGrid;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Getter;

@Getter
public class UsersMenu {
    private Button showUsers = new Button("users");
    private VerticalLayout userLayout = new VerticalLayout();
    private UserGrid userGrid;

    public UsersMenu(MainView mainView) {

        showUsers.addClickListener(event -> {
            userGrid = new UserGrid();
            userGrid.getUserDtoListGrid().setVisible(true);
            mainView.getPanelTwo().setVisible(true);
            mainView.getPanelTwo().addComponentAsFirst(userGrid.getUserDtoListGrid());
            mainView.getPanelTwo().setSizeFull();
            userGrid.userRefresh();
        });
        userLayout.add(showUsers);
    }

    public VerticalLayout getUserLayout() {
        return userLayout;
    }
}
