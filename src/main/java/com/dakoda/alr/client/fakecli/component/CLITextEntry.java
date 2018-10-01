package com.dakoda.alr.client.fakecli.component;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import static com.dakoda.alr.TextRPG.display;

public class CLITextEntry extends TextField {

    private String prefix = "$ ";
    private String prefixRegex = "[$] ";

    public static void init(CLITextEntry cliTextEntry) {
        cliTextEntry.setPrefColumnCount(90);
        cliTextEntry.getStyleClass().add("cli-text-field");
        cliTextEntry.initInstance();
    }

    public void initInstance() {
        setOnKeyTyped(event -> validatePrefixExistence(event.getCode()));
        setOnKeyPressed(event -> submitText(event.getCode(), this.getText()));
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

    private void submitText(KeyCode keyCode, String text) {
        System.out.println("#KEYLOG | Keycode: " + keyCode.getName() + " at Caret position: " + this.getCaretPosition());
        if (keyCode.equals(KeyCode.ENTER)) {
            refresh();
            String toSubmit = text.replaceFirst(prefixRegex, "");
            if (toSubmit.trim().length() >= 1 && !toSubmit.equals("\n")) {
                display.submit(toSubmit.trim());
            }
        }
    }

    public void refresh() {
        this.clear();
        this.setText(prefix);
        this.positionCaret(this.getText().length());
    }
}
