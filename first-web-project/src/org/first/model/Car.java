package org.first.model;

public class Car {
    //    //car ( id, model, company, engine, color, type )
    private int id;
    private String model;
    private String company;
    private String engine;
    private String color;
    private String type;

    public Car() {
    }

    public Car(int id, String model, String company, String engine, String color, String type) {
        this.id = id;
        this.model = model;
        this.company = company;
        this.engine = engine;
        this.color = color;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int carId) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", company='" + company + '\'' +
                ", engine='" + engine + '\'' +
                ", color='" + color + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
