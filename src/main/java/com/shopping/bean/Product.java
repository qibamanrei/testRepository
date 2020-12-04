package com.shopping.bean;

import java.util.Objects;

public class Product {
    private int proId;
    private String proName;
    private String ProNum;
    private double marketPrice;
    private double shopPrice;
    private String proColor;
    private int proTotalCount;
    private String proMaxImg;
    private String proMinImg;
    private int proState;

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProNum() {
        return ProNum;
    }

    public void setProNum(String proNum) {
        ProNum = proNum;
    }

    public double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public double getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(double shopPrice) {
        this.shopPrice = shopPrice;
    }

    public String getProColor() {
        return proColor;
    }

    public void setProColor(String proColor) {
        this.proColor = proColor;
    }

    public int getProTotalCount() {
        return proTotalCount;
    }

    public void setProTotalCount(int proTotalCount) {
        this.proTotalCount = proTotalCount;
    }

    public String getProMaxImg() {
        return proMaxImg;
    }

    public void setProMaxImg(String proMaxImg) {
        this.proMaxImg = proMaxImg;
    }

    public String getProMinImg() {
        return proMinImg;
    }

    public void setProMinImg(String proMinImg) {
        this.proMinImg = proMinImg;
    }

    public int getProState() {
        return proState;
    }

    public void setProState(int proState) {
        this.proState = proState;
    }

    @Override
    public String toString() {
        return "Product{" +
                "proId=" + proId +
                ", proName='" + proName + '\'' +
                ", ProNum='" + ProNum + '\'' +
                ", marketPrice=" + marketPrice +
                ", shopPrice=" + shopPrice +
                ", proColor='" + proColor + '\'' +
                ", proTotalCount=" + proTotalCount +
                ", proMaxImg='" + proMaxImg + '\'' +
                ", proMinImg='" + proMinImg + '\'' +
                ", proState=" + proState +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return proId == product.proId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(proId);
    }
}
