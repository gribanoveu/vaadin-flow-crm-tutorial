package com.example.application.views.list;

import com.example.application.security.SecurityService;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility;

import static com.vaadin.flow.component.Tag.H1;


public class MainLayout extends AppLayout {
    private final SecurityService service;


    public MainLayout(SecurityService service) {
        this.service = service;
        createHeader();
    }

    private void createHeader() {
        H1 logo = new H1("Vaadin CRM");
        logo.addClassNames(
                LumoUtility.FontSize.LARGE,
                LumoUtility.Margin.MEDIUM
        );

        String u = service.getAuthenticatedUser().getUsername();
        Button logout = new Button("Logout " + u, e -> service.logout());

        var header = new HorizontalLayout(
                logo,
                new RouterLink("List", ListView.class),
                logout
        );

        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.expand(logo);
        header.setWidthFull();

        addToNavbar(
                header
        );
    }
}
