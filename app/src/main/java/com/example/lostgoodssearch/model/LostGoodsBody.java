package com.example.lostgoodssearch.model;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name="body", strict = false)
public class LostGoodsBody {
    @ElementList(name = "items")
    private List<LostGoodsItems> items;

    public List<LostGoodsItems> getItems() {
        return items;
    }

    public void setItems(List<LostGoodsItems> items) {
        this.items = items;
    }
}
