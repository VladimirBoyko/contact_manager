package com.contactmanager;

public class Contact {
    private String name;
    private String phone;

    public Contact (String name, String phone){
        this.name = name;
        this.phone = phone;
    }

    public String getName(){
        return name;
    }

    public String toLine (){
        return  "* Name: " + name + "\n" + "Phone: " + phone + "\n";
    }
}
