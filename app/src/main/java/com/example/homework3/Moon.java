package com.example.homework3;

import android.net.sip.SipSession;

public class Moon {
    private String name;
    private String moon;
    private int landResources;


    public Moon(String name, String moon, int land) {
        this.name = name;
        this.moon = moon;
        this.landResources = land;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoon() {
        return this.moon;
    }

    public void setMoon(String moon) {
        this.moon = moon;
    }

    public int getLandResources() {
        return this.landResources;
    }

    public void setLandResources(int landResources) {
        this.landResources = landResources;
    }
}
