package com.pedromihael.cellphonedatabase;

public class Model {

    private String name;
    private String brand;

    public Model() { }

    public Model(String name, String brand) {
        this.name = name;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}
