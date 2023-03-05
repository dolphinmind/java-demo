package com.dolphinmind.functionalinterface.lambda;

public class Plants {
    String[] plants = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus",
            "Neptune"};

    public Plants() {
    }

    public Plants(String[] plants) {
        this.plants = plants;
    }

    public String[] getPlants() {
        return plants;
    }

    public void setPlants(String[] plants) {
        this.plants = plants;
    }
}
