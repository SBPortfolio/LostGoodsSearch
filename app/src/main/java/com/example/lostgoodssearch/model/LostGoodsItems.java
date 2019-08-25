package com.example.lostgoodssearch.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "item")
public class LostGoodsItems {
    @Element(name = "atcId")
    private String atcId;
    @Element(name = "lstPlace")
    private String lstPlace;
    @Element(name = "lstPrdtNm")
    private String lstPrdtNm;
    @Element(name = "lstSbjt")
    private String lstSbjt;
    @Element(name = "lstYmd")
    private String lstYmd;
    @Element(name = "prdtClNm")
    private String prdtClNm;
    @Element(name = "rnum")
    private int rnum;

    public String getAtcId() {
        return atcId;
    }

    public void setAtcId(String atcId) {
        this.atcId = atcId;
    }

    public String getLstPlace() {
        return lstPlace;
    }

    public void setLstPlace(String lstPlace) {
        this.lstPlace = lstPlace;
    }

    public String getLstPrdtNm() {
        return lstPrdtNm;
    }

    public void setLstPrdtNm(String lstPrdtNm) {
        this.lstPrdtNm = lstPrdtNm;
    }

    public String getLstSbjt() {
        return lstSbjt;
    }

    public void setLstSbjt(String lstSbjt) {
        this.lstSbjt = lstSbjt;
    }

    public String getLstYmd() {
        return lstYmd;
    }

    public void setLstYmd(String lstYmd) {
        this.lstYmd = lstYmd;
    }

    public String getPrdtClNm() {
        return prdtClNm;
    }

    public void setPrdtClNm(String prdtClNm) {
        this.prdtClNm = prdtClNm;
    }

    public int getRnum() {
        return rnum;
    }

    public void setRnum(int rnum) {
        this.rnum = rnum;
    }
}
