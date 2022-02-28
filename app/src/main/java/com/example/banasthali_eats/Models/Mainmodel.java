package com.example.banasthali_eats.Models;

public class Mainmodel{
    int image;
    String name,price,Tcount;
    int add,minus;



    public Mainmodel(int image, String name, String price,int add,int minus,String Tcount) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.add = add;
        this.minus = minus;
        this.Tcount = Tcount;
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

    public String getTcount() {
        return Tcount ;
    }

    public void setTcount(String count) {
        this.Tcount = Tcount;
    }
}
