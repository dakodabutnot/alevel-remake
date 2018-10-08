package com.dakoda.alr.client.fakecli.components;

public class CSSRequest {

    private int beginning;
    private int end;
    private String request;

    public CSSRequest(int beginning, int end, String request) {
        this.beginning = beginning;
        this.end = end;
        this.request = request;
    }

    public int getBeginning() {
        return beginning;
    }

    public int getEnd() {
        return end;
    }

    public String get() {
        return request;
    }
}
