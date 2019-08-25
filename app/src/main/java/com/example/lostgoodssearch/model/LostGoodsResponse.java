package com.example.lostgoodssearch.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "response", strict = false)
public class LostGoodsResponse {
    @Element(name = "body")
    private LostGoodsBody body;

    public LostGoodsBody getBody() {
        return body;
    }

    public void setBody(LostGoodsBody body) {
        this.body = body;
    }
}
