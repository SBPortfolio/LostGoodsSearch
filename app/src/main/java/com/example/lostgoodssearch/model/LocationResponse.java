package com.example.lostgoodssearch.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "response", strict = false)
public class LocationResponse {
    @Element(name = "body")
    private LocationBody body;

    public LocationBody getBody() {
        return body;
    }

    public void setBody(LocationBody body) {
        this.body = body;
    }
}
