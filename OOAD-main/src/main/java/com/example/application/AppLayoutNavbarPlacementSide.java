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
import com.vaadin.flow.component.html.Paragraph;

@PageTitle("Encodify Home Page")
@Route(value = "dashboard")
public class AppLayoutNavbarPlacementSide extends AppLayout {

    public AppLayoutNavbarPlacementSide() {
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("Encodify - Text Encoding & Decoding Services");
        title.getStyle().set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "0");

        Paragraph description = new Paragraph(
                "Encodify provides innovative text encoding and decoding services. \n" +
                        "Our platform allows users to encode and decode text using audio input " +
                        "and offers various algorithms such as Caesar cipher, Hashing, Morse code, and more.");
        description.getStyle().set("padding", "2em");

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.add(description);
        setContent(horizontalLayout);

        SideNav nav = getSideNav();

        Scroller scroller = new Scroller(nav);
        scroller.setClassName(LumoUtility.Padding.SMALL);

        addToDrawer(scroller);
        addToNavbar(toggle, title);

        setPrimarySection(Section.DRAWER);
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
