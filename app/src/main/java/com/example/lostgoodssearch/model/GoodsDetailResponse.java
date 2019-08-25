package com.example.lostgoodssearch.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "response", strict = false)
public class GoodsDetailResponse {
    @Element(name = "body")
    private GoodsDetailBody body;

    public GoodsDetailBody getBody() {
        return body;
    }

    public void setBody(GoodsDetailBody body) {
        this.body = body;
    }
}
