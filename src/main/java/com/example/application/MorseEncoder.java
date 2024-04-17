package com.example.application;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

import java.util.HashMap;
import java.util.Map;

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

        morseEncoding();
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
    private String generateMorseEncodedText(String t1)
    {
        Map<Character, String> morseCodeMap = new HashMap<>();
        morseCodeMap.put('A', ".-");
        morseCodeMap.put('B', "-...");
        morseCodeMap.put('C', "-.-.");
        morseCodeMap.put('D', "-..");
        morseCodeMap.put('E', ".");
        morseCodeMap.put('F', "..-.");
        morseCodeMap.put('G', "--.");
        morseCodeMap.put('H', "....");
        morseCodeMap.put('I', "..");
        morseCodeMap.put('J', ".---");
        morseCodeMap.put('K', "-.-");
        morseCodeMap.put('L', ".-..");
        morseCodeMap.put('M', "--");
        morseCodeMap.put('N', "-.");
        morseCodeMap.put('O', "---");
        morseCodeMap.put('P', ".--.");
        morseCodeMap.put('Q', "--.-");
        morseCodeMap.put('R', ".-.");
        morseCodeMap.put('S', "...");
        morseCodeMap.put('T', "-");
        morseCodeMap.put('U', "..-");
        morseCodeMap.put('V', "...-");
        morseCodeMap.put('W', ".--");
        morseCodeMap.put('X', "-..-");
        morseCodeMap.put('Y', "-.--");
        morseCodeMap.put('Z', "--..");

        // Convert plain text to upper case
        String plainText = t1.toUpperCase();

        // StringBuilder to hold the Morse code
        StringBuilder morseEncodedText = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char c = plainText.charAt(i);

            if (Character.isLetter(c)) {
                String morseCode = morseCodeMap.get(c);
                if (morseCode != null) {
                    morseEncodedText.append(morseCode).append(" ");
                }
            }
            else if (Character.isWhitespace(c)) {
                morseEncodedText.append(" ");
            }
        }
        return morseEncodedText.toString();
    }
    private void morseEncoding()
    {
        // Create text field for plain text input
        TextField text = new TextField("Plain Text");
        text.setRequiredIndicatorVisible(true);
        text.setMinLength(2);
        text.setHelperText("Enter Text to be encrypted");

        TextField encodedText = new TextField("Morse Encoded Text");
        encodedText.setReadOnly(true);
        Button button = new Button("Submit");
        button.addClickListener(e -> {
            String plainText = text.getValue();
            String morseEncodedText = generateMorseEncodedText(plainText);
            encodedText.setValue(morseEncodedText);
        });
        VerticalLayout layout = new VerticalLayout();
        layout.add(text, button, encodedText);
        addToDrawer(layout);
    }
    // tag::snippet[]
}
// end::snippet[]

