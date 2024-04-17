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

import java.util.HashMap;
import java.util.Map;

@PageTitle("Encodify-Morse Decoder")
@Route(value = "/MorseDecoder")
public class MorseDecoder extends AppLayout {

    public MorseDecoder() {
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("Encodify-Morse Decoder");
        title.getStyle().set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "0");

        SideNav nav = getSideNav();

        Scroller scroller = new Scroller(nav);
        scroller.setClassName(LumoUtility.Padding.SMALL);

        addToDrawer(scroller);
        addToNavbar(toggle, title);

        setPrimarySection(Section.DRAWER);
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

    // Morse Code Map
    private static final Map<String, Character> morseMap = new HashMap<>();
    static {
        morseMap.put(".-", 'A');
        morseMap.put("-...", 'B');
        morseMap.put("-.-.", 'C');
        morseMap.put("-..", 'D');
        morseMap.put(".", 'E');
        morseMap.put("..-.", 'F');
        morseMap.put("--.", 'G');
        morseMap.put("....", 'H');
        morseMap.put("..", 'I');
        morseMap.put(".---", 'J');
        morseMap.put("-.-", 'K');
        morseMap.put(".-..", 'L');
        morseMap.put("--", 'M');
        morseMap.put("-.", 'N');
        morseMap.put("---", 'O');
        morseMap.put(".--.", 'P');
        morseMap.put("--.-", 'Q');
        morseMap.put(".-.", 'R');
        morseMap.put("...", 'S');
        morseMap.put("-", 'T');
        morseMap.put("..-", 'U');
        morseMap.put("...-", 'V');
        morseMap.put(".--", 'W');
        morseMap.put("-..-", 'X');
        morseMap.put("-.--", 'Y');
        morseMap.put("--..", 'Z');
        morseMap.put(".----", '1');
        morseMap.put("..---", '2');
        morseMap.put("...--", '3');
        morseMap.put("....-", '4');
        morseMap.put(".....", '5');
        morseMap.put("-....", '6');
        morseMap.put("--...", '7');
        morseMap.put("---..", '8');
        morseMap.put("----.", '9');
        morseMap.put("-----", '0');
    }

    // Method to decode Morse code to text
    private String decodeMorse(String morseCode) {
        StringBuilder decodedText = new StringBuilder();

        // Split Morse code by space to get individual Morse characters
        String[] morseChars = morseCode.trim().split(" ");

        // Iterate through Morse characters
        for (String character : morseChars) {
            // Check if Morse character is not empty
            if (!character.isEmpty()) {
                // Look up character for Morse code
                Character decodedChar = morseMap.get(character);
                if (decodedChar != null) {
                    decodedText.append(decodedChar);
                }
            } else {
                // If Morse character is empty (indicates space between words), add space
                decodedText.append(" ");
            }
        }

        return decodedText.toString();
    }
}

private void morseDecodingUI() {
    // Create text field for Morse code input
    TextField morseTextField = new TextField("Morse Code");
    morseTextField.setPlaceholder("Enter Morse code");
    morseTextField.setWidth("300px");

    // Create text field to display the decoded text
    TextField decodedTextField = new TextField("Decoded Text");
    decodedTextField.setReadOnly(true); // Set as read-only to prevent user input

    // Create button to trigger decoding process
    Button decodeButton = new Button("Decode");
    decodeButton.addClickListener(e -> {
        // Retrieve the Morse code input
        String morseCode = morseTextField.getValue();
        // Decode the Morse code
        String decodedText = decodeMorse(morseCode);
        // Set the decoded text to the appropriate text field
        decodedTextField.setValue(decodedText);
    });

    // Add components to the layout
    VerticalLayout layout = new VerticalLayout();
    layout.add(morseTextField, decodeButton, decodedTextField); // Add text field, button, and decoded text field to the layout

    // Set the layout as the content of the AppLayout
    setContent(layout);
}
}
