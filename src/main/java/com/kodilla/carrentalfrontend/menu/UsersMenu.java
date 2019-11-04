package com.kodilla.carrentalfrontend.menu;

import com.kodilla.carrentalfrontend.mainview.MainView;
import com.kodilla.carrentalfrontend.grid.UserGrid;
import com.kodilla.carrentalfrontend.workingarea.AddUser;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Getter;

@Getter
public class UsersMenu {
    private Button createUser = new Button("create user");
    private Button showUsers = new Button("users");
    private VerticalLayout userLayout = new VerticalLayout();
    private UserGrid userGrid;

    public UsersMenu(MainView mainView) {
        createUser.addClickListener(event -> {
            AddUser addUser = new AddUser(mainView);
            addUser.getAddUserLayout().setVisible(true);
            mainView.getPanelTwo().add(addUser.getAddUserLayout());
        });

        showUsers.addClickListener(event -> {
            userGrid = new UserGrid();
            userGrid.getUserDtoListGrid().setVisible(true);
            mainView.getPanelTwo().removeAll();
            mainView.getPanelTwo().setVisible(true);
            mainView.getPanelTwo().addComponentAsFirst(userGrid.getUserDtoListGrid());
            mainView.getPanelTwo().setSizeFull();
            userGrid.userRefresh();
        });
        userLayout.add(createUser, showUsers);
    }

    public VerticalLayout getUserLayout() {
        return userLayout;
    }
}
