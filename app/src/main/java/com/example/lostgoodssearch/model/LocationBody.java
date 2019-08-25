package com.example.lostgoodssearch.model;

import org.simpleframework.xml.ElementList;

import java.util.List;

public class LocationBody {
    @ElementList(name = "items")
    private List<LocationItems> items;

    public List<LocationItems> getItems() {
        return items;
    }

    public void setItems(List<LocationItems> items) {
        this.items = items;
    }
}
