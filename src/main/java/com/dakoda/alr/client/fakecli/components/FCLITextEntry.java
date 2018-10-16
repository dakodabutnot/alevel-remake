package com.dakoda.alr.client.fakecli.components;

import com.dakoda.alr.TextRPG;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class FCLITextEntry extends TextField {

    private String prefix = "$ ";
    private String prefixRegex = "[$] ";

    public static void init(FCLITextEntry fcliTextEntry, FCLIDisplay fcliDisplay) {
        fcliTextEntry.setPrefColumnCount(90);
        fcliTextEntry.getStyleClass().add("fcli-text-field");
        fcliTextEntry.initInstance(fcliDisplay);
    }

    public void displaySubmitRedirect(KeyEvent event, FCLIDisplay display) {
        submitText(display, event.getCode(), this.getText());
    }

    public void displayTypeRedirect(KeyEvent event) {
        validatePrefixExistence(event.getCode());
    }

    public void initInstance(FCLIDisplay display) {
        setOnKeyTyped(event -> validatePrefixExistence(event.getCode()));
        setOnKeyPressed(event -> submitText(display, event.getCode(), this.getText()));
    }

    private void validatePrefixExistence(KeyCode keyCode) {
        if (this.getCaretPosition() < prefix.length()) {
            refresh();
        }
        if (this.getCaretPosition() == prefix.length() && (keyCode.equals(KeyCode.BACK_SPACE))) {
            refresh();
        }
        String text = this.getText();
        if (!text.contains(prefix) || this.getText().charAt(0) != prefix.charAt(0)) {
            refresh();
        } else if (!(this.getText().replaceFirst(prefixRegex, "").length() >= 1)) {
            refresh();
        }
    }

    private void submitText(FCLIDisplay fcliDisplay, KeyCode keyCode, String text) {
        TextRPG.debugMessage("#KEYLOG | key " + keyCode.getName() + " pressed at caret position " + getCaretPosition());
        if (keyCode.equals(KeyCode.ENTER)) {
            refresh();
            String toSubmit = text.replaceFirst(prefixRegex, "");
            if (toSubmit.trim().length() >= 1) {
                fcliDisplay.submit(toSubmit.trim());
            }
        }
    }

    public void refresh() {
        this.clear();
        this.setText(prefix);
        this.positionCaret(this.getText().length());
    }
}
