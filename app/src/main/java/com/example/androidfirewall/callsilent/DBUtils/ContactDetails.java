package com.example.androidfirewall.callsilent.DBUtils;


public class ContactDetails {

    String name;
    String number;
    String photo;

    public ContactDetails(String name, String number, String photo) {
        this.name = name;
        this.number = number;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getPhoto() {
        return photo;
    }
}
