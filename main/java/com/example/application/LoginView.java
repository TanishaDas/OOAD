
package com.example.application;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("")
@PageTitle("Login")
public class LoginView extends VerticalLayout {

    public LoginView() {
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        setWidthFull();
        setHeightFull();

        H1 title = new H1("Login");

        FormLayout loginForm = new FormLayout();
        loginForm.setResponsiveSteps(new FormLayout.ResponsiveStep("0", 1));

        TextField usernameField = new TextField("Username");
        usernameField.setPlaceholder("Enter your username");
        usernameField.setWidth("250px");

        PasswordField passwordField = new PasswordField("Password");
        passwordField.setPlaceholder("Enter your password");
        passwordField.setWidth("250px");

        Button loginButton = new Button("Login");
        loginButton.setWidth("250px");
        loginButton.addClickListener(e -> {
            String username = usernameField.getValue();
            String password = passwordField.getValue();

            if ("admin".equals(username) && "admin".equals(password)) {
                getUI().ifPresent(ui -> ui.navigate("admin-dashboard"));
            } else {
                getUI().ifPresent(ui -> ui.navigate("dashboard"));
            }
        });

        loginForm.add(usernameField, passwordField, loginButton);
        loginForm.setColspan(usernameField, 2);
        loginForm.setColspan(passwordField, 2);
        loginForm.setColspan(loginButton, 2);

        add(title, loginForm);
    }
}

