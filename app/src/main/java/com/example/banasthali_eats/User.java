package com.example.banasthali_eats;

public class User {
    public String fullName, email;
//    long createdAt;
    public User(){

    }
    public User(String fullName, String email){
        this.fullName = fullName;
        this.email = email;
//        this.createdAt = createdAt;
    }

    public String getFullName(){
        return fullName;
    }

    public String getEmail() {
        return email;
    }

//    public long getCreatedAt() {
//        return createdAt;
//    }
}
