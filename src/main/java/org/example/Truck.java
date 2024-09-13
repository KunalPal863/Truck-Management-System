package org.example;

public class Truck {
    private int id;
    private String tname;
    private String dname;
    private String model;
    private String capacity;

    public Truck()
    {

    }
    public Truck( String tname, String dname, String model, String capacity) {
        this.tname = tname;
        this.dname = dname;
        this.model = model;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "Id = " + id +
                ", Truck_name = '" + tname + '\'' +
                ", Driver_name = '" + dname + '\'' +
                ", Model = '" + model + '\'' +
                ", Capacity = '" + capacity + '\'' +
                '}';
    }
}
