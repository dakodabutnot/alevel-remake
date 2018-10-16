package com.dakoda.alr.client.fakecli.components;

import com.dakoda.alr.TextRPG;
import com.dakoda.alr.client.fakecli.FCLIMaster;
import org.fxmisc.richtext.InlineCssTextArea;

import java.util.ArrayList;
import java.util.List;

public class FCLIDisplay extends InlineCssTextArea {

    @SuppressWarnings("FieldCanBeLocal")
    private int prefRowCount = 0;
    private List<FCLIText> lines = new ArrayList<>();

    public void init() {
        this.setWrapText(true);
        this.setEditable(false);
        this.setFocusTraversable(false);
        this.getStyleClass().add("fcli-text-area");
        TextRPG.debugMessage("#FX | Initialized display");
//        This isn't working ¯\_(ツ)_/¯
//        setOnKeyTyped(event -> FCLIMaster.instance().fxMaster().fcliTextEntry().displayTypeRedirect(event));
//        setOnKeyPressed(event -> FCLIMaster.instance().fxMaster().fcliTextEntry().displaySubmitRedirect(event, this));
        this.updateDisplay();
    }

    public List<FCLIText> lines() {
        return lines;
    }

    public void setPrefRowCount(int prefRowCount) {
        this.prefRowCount = prefRowCount;
    }

    private void updateDisplay() {
        StringBuilder finalDisplay = new StringBuilder();
        ArrayList<CSSRequest> CSSRequests = new ArrayList<>();
        for (FCLIText line : lines) {
            int beginning = finalDisplay.length();
            int end = finalDisplay.length() + line.toString().length();
            finalDisplay.append(line.toString());
            CSSRequests.add(new CSSRequest(beginning, end, "-fx-fill: " + line.getColour()));
        }
        this.replaceText(finalDisplay.toString());
        for (CSSRequest request : CSSRequests) {
            this.setStyle(request.getBeginning(), request.getEnd(), request.get());
        }
        TextRPG.debugMessage("#FX | Refreshed display content");
    }

    private void bump() {
        this.scrollYToPixel(Double.MAX_VALUE);
        TextRPG.debugMessage("#FX | Bumped display");
    }

    private void trimLines() {
        while (lines.size() > (getPrefRowCount())) {
            TextRPG.debugMessage("#FX-DISPLAY | Trimmed line " + lines.get(0));
            lines.remove(lines.get(0));
        }
    }

    private int getPrefRowCount() {
        return prefRowCount;
    }

    public void refresh() {
        trimLines();
        updateDisplay();
        bump();
        TextRPG.debugMessage("#FX-DISPLAY | Current lines: " + lines.size());
    }

//    public void clear() {
//        lines = new ArrayList<>();
//        refresh();
//    }

    public void pushLine(String line) {
        this.lines.add(new FCLIText(line));
        TextRPG.debugMessage("#FX-DISPLAY | Pushed line, length " + line.length());
    }

    public void pushLine(String line, String colour) {
        this.lines.add(new FCLIText(line, colour));
        TextRPG.debugMessage("#FX-DISPLAY | Pushed line, length " + line.length() + ", CSS style '-fx-fill: " + colour + "'");
    }

    void submit(String line) {
        pushLine(line);
        FCLIMaster.instance().stateMaster().notifyWithString(line);
        refresh();
    }

//    private void pushLines(String... lines) {
//        for (String line : lines) {
//            this.lines.add(new FCLIText(line));
//            TextRPG.debugMessage("#FX-DISPLAY | Pushed line, length " + line.length());
//        }
//    }

    public void flush() {
        lines = new ArrayList<>();
//        lines.add(new FCLIText("\n"));
        TextRPG.debugMessage("#FX | Flushed display");
    }
}