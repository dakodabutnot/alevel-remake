package com.dakoda.alr.client.fakecli.component;

import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CLIDisplay extends TextArea {

    private List<String> lines = new ArrayList<>();

    public static void init(CLIDisplay cliDisplay) {
        cliDisplay.setWrapText(true);
        cliDisplay.setPrefColumnCount(90);
        cliDisplay.setEditable(false);
        cliDisplay.setFocusTraversable(false);
        cliDisplay.getStyleClass().add("cli-text-area");
        cliDisplay.updateDisplay();
    }

    public void setLineLimit(Integer limit) {
        this.setPrefRowCount(limit);
    }

    public List<String> lines() {
        return lines;
    }

    private void updateDisplay() {
        StringBuilder finalDisplay = new StringBuilder();
        for (String line : lines) {
            finalDisplay.append(line);
        }
        this.setText(finalDisplay.toString());
    }

    private void bump() {
        this.setScrollTop(Double.MAX_VALUE);
    }

    private void trimLines() {
        while (lines.size() > (getPrefRowCount())) {
            lines.remove(lines.get(0));
        }
    }

    private void splitLines() {
        lines.forEach(s -> {
            if (s.length() > getPrefColumnCount()) {

            }
        });
        trimLines();
    }

    public void refresh() {
        splitLines();
        trimLines();
        updateDisplay();
        bump();
    }

    public void clear() {
        lines = new ArrayList<>();
        refresh();
    }

    public void pushLine(String line) {
        this.lines.add(line + "\n");
        System.out.println("#LOG | Printed line \"" + line + "\".");
    }

    void submit(String line) {
        pushLine(line);
        refresh();
    }

    private void pushLines(String... lines) {
        this.lines.addAll(Arrays.asList(lines));
    }

    private void flush() {
        lines = new ArrayList<>();
    }
}