package com.bidhee.model;

/**
 * Created by user on 9/10/2015.
 */
public class CategoryModel {
    private int catID;

    public int getCatID() {
        return catID;
    }

    public void setCatID(int catID) {
        this.catID = catID;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatDetails() {
        return catDetails;
    }

    public void setCatDetails(String catDetails) {
        this.catDetails = catDetails;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getCatImage() {
        return catImage;
    }

    public void setCatImage(String catImage) {
        this.catImage = catImage;
    }

    private String catName;
    private String catDetails;
    private double lat;
    private double lon;
    private String catImage;

    public CategoryModel(int catID, String catName, String catDetails, double lat, double lon, String catImage){
        this.catID = catID;
        this.catName = catName;
        this.catDetails = catDetails;
        this.lat = lat;
        this.lon = lon;
        this.catImage = catImage;

    }

    public CategoryModel(){

    }



}
