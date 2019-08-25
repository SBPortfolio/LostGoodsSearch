package com.example.lostgoodssearch.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "body")
public class GoodsDetailBody {
    @Element(name="item")
    public GoodsDetailItems item;

    public GoodsDetailItems getItems() {
        return item;
    }

    public void setItems(GoodsDetailItems item) {
        this.item = item;
    }
}
