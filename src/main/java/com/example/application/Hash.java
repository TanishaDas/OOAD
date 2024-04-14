package com.example.application;

import java.math.BigInteger;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle("Encodify-Hash Generator")
@Route(value = "/Hash")
public class Hash extends AppLayout {

    public Hash() {
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("Encodify-Hash Generator");
        title.getStyle().set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "4");

        SideNav nav = getSideNav();

        Scroller scroller = new Scroller(nav);
        scroller.setClassName(LumoUtility.Padding.SMALL);

        addToDrawer(scroller);
        addToNavbar(toggle, title);

        setPrimarySection(Section.DRAWER);

        
        addHashGenerationUI();
    }

    private SideNav getSideNav() {
        SideNav nav = new SideNav();
        nav.addItem(new SideNavItem("Dashboard", "",
                        VaadinIcon.DASHBOARD.create()),
                new SideNavItem("CeaserCypher", "/CeaserCypher",
                        VaadinIcon.CHEVRON_RIGHT.create()),
                new SideNavItem("Hash Generator", "/Hash",
                        VaadinIcon.CHEVRON_RIGHT.create()),
                new SideNavItem("Morse Encoder", "/MorseEncoder",
                        VaadinIcon.CHEVRON_RIGHT.create()),
                new SideNavItem("Morse Decoder", "/MorseDecoder",
                        VaadinIcon.CHEVRON_RIGHT.create()));
        return nav;
    }

    private void addHashGenerationUI() {
        VerticalLayout hashLayout = new VerticalLayout();
        hashLayout.setAlignItems(Alignment.START);

        Label titleLabel = new Label("Enter text:");

        titleLabel.getStyle().set("margin-right", "30px");

        com.vaadin.flow.component.textfield.TextField textField = new com.vaadin.flow.component.textfield.TextField();
        textField.setPlaceholder("Enter text to hash");
        textField.setWidth("300px");

       
        com.vaadin.flow.component.button.Button generateButton = new com.vaadin.flow.component.button.Button("Generate Hash");
        Label hashLabel = new Label();
        generateButton.addClickListener(e -> {
            String inputText = textField.getValue();
            String hashedText = generateSHA256Hash(inputText);
            hashLabel.setText("Hash: " + hashedText);
        });

        hashLayout.add(titleLabel, textField, generateButton, hashLabel);
        setContent(hashLayout);
    }

    private String generateSHA256Hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(input.getBytes(StandardCharsets.UTF_8));
            BigInteger number = new BigInteger(1, hash);
            StringBuilder hexString = new StringBuilder(number.toString(16));
            while (hexString.length() < 64) {
                hexString.insert(0, '0');
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
