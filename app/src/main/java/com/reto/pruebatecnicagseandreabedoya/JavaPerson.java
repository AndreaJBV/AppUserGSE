package com.reto.pruebatecnicagseandreabedoya;

public class JavaPerson {
    //ATTRIBUTES
    private String name;
    private String lastName;
    private Integer height;
    private Double weight;

    private Double increaseWeight;
    private Integer growUp;

    //CONSTRUCTOR
    public JavaPerson(String name, String lastName, Integer height, Double weight) {
        this.name = name;
        this.lastName = lastName;
        this.height = height;
        this.weight = weight;
    }

    //METHODS
    public Double eat(){
        increaseWeight = weight +1;
        return increaseWeight;
    }

    public Integer  growUp(){
        growUp = height+1;
        return growUp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
