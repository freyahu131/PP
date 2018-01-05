package com.project.pp.parentparadise.freya;

/**
 * Created by mac on 2017/12/13.
 */



public class CommunityFItem {

    private int image;
    private String itemName;


    public CommunityFItem(int image, String itemName) {
        super();
        this.image = image;
        this.itemName = itemName;

    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

}