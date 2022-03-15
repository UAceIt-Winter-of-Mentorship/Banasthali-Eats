package com.example.banasthali_eats.Models;

import androidx.annotation.NonNull;

public class Mainmodel{
    int image;
    String name,price;
    int add,minus,Tcount;



    public Mainmodel(int image, String name, String price,int add,int minus,int tcount) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.add = add;
        this.minus = minus;
        this.Tcount = tcount;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getTcount() {
        return Tcount ;
    }

    public void setTcount(int count) {
        this.Tcount = Tcount;
    }

    @NonNull
    @Override
    public String toString() {
        return name+" "+Tcount;
    }
}
