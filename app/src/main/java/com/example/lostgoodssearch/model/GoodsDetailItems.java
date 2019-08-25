package com.example.lostgoodssearch.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "item", strict = false)
public class GoodsDetailItems {
    @Element
    private String atcId;
    @Element
    private String lstFilePathImg;
    @Element
    private String lstHor;
    @Element
    private String lstLctNm;
    @Element
    private String lstPlace;
    @Element
    private String lstPlaceSeNm;
    @Element
    private String lstPrdtNm;
    @Element
    private String lstSbjt;
    @Element
    private String lstSteNm;
    @Element
    private String lstYmd;
    @Element
    private String orgId;
    @Element
    private String orgNm;
    @Element
    private String prdtClNm;
    @Element
    private String tel;
    @Element
    private String uniq;

    public String getAtcId() {
        return atcId;
    }

    public void setAtcId(String atcId) {
        this.atcId = atcId;
    }

    public String getLstFilePathImg() {
        return lstFilePathImg;
    }

    public void setLstFilePathImg(String lstFilePathImg) {
        this.lstFilePathImg = lstFilePathImg;
    }

    public String getLstHor() {
        return lstHor;
    }

    public void setLstHor(String lstHor) {
        this.lstHor = lstHor;
    }

    public String getLstLctNm() {
        return lstLctNm;
    }

    public void setLstLctNm(String lstLctNm) {
        this.lstLctNm = lstLctNm;
    }

    public String getLstPlace() {
        return lstPlace;
    }

    public void setLstPlace(String lstPlace) {
        this.lstPlace = lstPlace;
    }

    public String getLstPlaceSeNm() {
        return lstPlaceSeNm;
    }

    public void setLstPlaceSeNm(String lstPlaceSeNm) {
        this.lstPlaceSeNm = lstPlaceSeNm;
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

    public String getLstSteNm() {
        return lstSteNm;
    }

    public void setLstSteNm(String lstSteNm) {
        this.lstSteNm = lstSteNm;
    }

    public String getLstYmd() {
        return lstYmd;
    }

    public void setLstYmd(String lstYmd) {
        this.lstYmd = lstYmd;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgNm() {
        return orgNm;
    }

    public void setOrgNm(String orgNm) {
        this.orgNm = orgNm;
    }

    public String getPrdtClNm() {
        return prdtClNm;
    }

    public void setPrdtClNm(String prdtClNm) {
        this.prdtClNm = prdtClNm;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUniq() {
        return uniq;
    }

    public void setUniq(String uniq) {
        this.uniq = uniq;
    }
}
