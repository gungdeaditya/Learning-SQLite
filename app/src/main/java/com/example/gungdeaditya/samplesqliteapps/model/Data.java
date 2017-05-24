package com.example.gungdeaditya.samplesqliteapps.model;

/**
 * Created by Gungde Aditya on 07/02/2016.
 */
public class Data {
    private String name;
    private String mob;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Data(String name, String mob, String email){
        this.name = name;
        this.mob = mob;
        this.email = email;

    }
}
