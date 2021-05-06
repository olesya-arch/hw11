package com.company;

public class Addresses {
    int id;
    String city;
    String street;
    int numberHouse;
    int houseBuilding;
    int flat;

    public Addresses(int id, String city, String street, int numberHouse, int houseBuilding, int flat) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.numberHouse = numberHouse;
        this.houseBuilding = houseBuilding;
        this.flat = flat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumberHouse() {
        return numberHouse;
    }

    public void setNumberHouse(int numberHouse) {
        this.numberHouse = numberHouse;
    }

    public int getHouseBuilding() {
        return houseBuilding;
    }

    public void setHouseBuilding(int houseBuilding) {
        this.houseBuilding = houseBuilding;
    }

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

    @Override
    public String toString() {
        return "Addresses{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", numberHouse=" + numberHouse +
                ", houseBuilding='" + houseBuilding + '\'' +
                ", flat='" + flat + '\'' +
                '}';
    }

  //  public static Addresses createFoAdding(String city, String street, int numberHouse, int houseBuilding, int flat) {
  //      return new Addresses(-1, city, street, numberHouse, houseBuilding, flat);

  //  }
}