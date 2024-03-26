package com.example.application;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle("Encodify-Morse Encoder")
@Route(value = "/MorseEncoder")
public class MorseEncoder extends AppLayout {

    public MorseEncoder() {
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("Encodify-Morse Encoder");
        title.getStyle().set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "0");

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

