package com.example.application;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import java.io.InputStream;

@PageTitle("Encodify-CeaserCypher")
@Route(value = "/CeaserCypher")
public class CeaserCypher extends AppLayout {

    public CeaserCypher() {
        DrawerToggle toggle = new DrawerToggle();

        MultiFileMemoryBuffer buffer = new MultiFileMemoryBuffer();
        Upload upload = new Upload(buffer);

        upload.addSucceededListener(event -> {
            String fileName = event.getFileName();
            InputStream inputStream = buffer.getInputStream(fileName);

            // Do something with the file data
            // processFile(inputStream, fileName);
        });

        Upload upload2 = new Upload(buffer);

        upload2.addSucceededListener(event -> {
            String fileName = event.getFileName();
            InputStream inputStream = buffer.getInputStream(fileName);

            // Do something with the file data
            // processFile(inputStream, fileName);
        });

        H1 title = new H1("Encodify-CeaserCypher");
        title.getStyle().set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "0");

        SideNav nav = getSideNav();

        Scroller scroller = new Scroller(nav);
        scroller.setClassName(LumoUtility.Padding.SMALL);

        addToDrawer(scroller);
        addToNavbar(toggle, title);

        setPrimarySection(Section.DRAWER);

        TextField phoneNumberField = new TextField("Plain Text");
        phoneNumberField.setRequiredIndicatorVisible(true);
        phoneNumberField.setMinLength(2);
        phoneNumberField.setHelperText("Enter Text to be encrypted");

        Button plusButton = new Button(new Icon(VaadinIcon.PLUS));
        plusButton.addThemeVariants(ButtonVariant.LUMO_ICON);
        plusButton.setAriaLabel("Add audio file");

        TextField anotherField = new TextField("Shift");
        Button button = new Button("Submit");

        // Vertical layout containing text fields and button
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.add(phoneNumberField,upload, anotherField, button);

        // Another set of text fields and button
        TextField phoneNumberField2 = new TextField("Encrypted Text");
        phoneNumberField2.setRequiredIndicatorVisible(true);
        phoneNumberField2.setMinLength(2);
        phoneNumberField2.setHelperText("Enter Text to be decrypted");


        Button plusButton2 = new Button(new Icon(VaadinIcon.PLUS));
        plusButton2.addThemeVariants(ButtonVariant.LUMO_ICON);
        plusButton2.setAriaLabel("Add audio file");

        TextField anotherField2 = new TextField("Shift");

        Button button2 = new Button("Submit");

        // Vertical layout containing second set of text fields and button
        VerticalLayout verticalLayout2 = new VerticalLayout();
        verticalLayout2.add(phoneNumberField2, upload2, anotherField2, button2 );

        // Horizontal layout containing both vertical layouts
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.add(verticalLayout, verticalLayout2);

        // Add the horizontal layout to the AppLayout
        setContent(horizontalLayout);
    }
    // end::snippet[]

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

    // tag::snippet[]
}
// end::snippet[]

