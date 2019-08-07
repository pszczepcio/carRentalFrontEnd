package com.kodilla.carrentalfrontend.menu;

import com.kodilla.carrentalfrontend.domain.MainView;
import com.kodilla.carrentalfrontend.grid.UserGrid;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class UsersMenu {
    private Button showUsers = new Button("useres");
    private VerticalLayout userLayout = new VerticalLayout();
    private UserGrid userGrid;

    public UsersMenu(MainView mainView) {
        userGrid = new UserGrid(mainView);
        showUsers.addClickListener(event -> {
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

    public UserGrid getUserGrid() {
        return userGrid;
    }
}
