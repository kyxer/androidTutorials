package com.bignerdranch.android.menudrawer.Models;

/**
 * Created by it-german on 8/23/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class Car {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("car_name")
    @Expose
    private String carName;
    @SerializedName("car_make")
    @Expose
    private String carMake;
    @SerializedName("car_model")
    @Expose
    private String carModel;
    @SerializedName("car_trim")
    @Expose
    private String carTrim;
    @SerializedName("km")
    @Expose
    private String km;
    @SerializedName("car_year")
    @Expose
    private String carYear;
    @SerializedName("transmission")
    @Expose
    private String transmission;
    @SerializedName("traction")
    @Expose
    private String traction;
    @SerializedName("body_type")
    @Expose
    private String bodyType;
    @SerializedName("ext_color")
    @Expose
    private String extColor;
    @SerializedName("doors")
    @Expose
    private String doors;
    @SerializedName("seats")
    @Expose
    private String seats;
    @SerializedName("cylinder")
    @Expose
    private String cylinder;
    @SerializedName("fuel_type")
    @Expose
    private String fuelType;
    @SerializedName("uber_type")
    @Expose
    private Object uberType;
    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("market_price")
    @Expose
    private Double marketPrice;
    @SerializedName("savings")
    @Expose
    private Double savings;
    @SerializedName("fepm")
    @Expose
    private Double fepm;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("avg_fuel_consumption")
    @Expose
    private String avgFuelConsumption;
    @SerializedName("status")
    @Expose
    private StatusCar status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarTrim() {
        return carTrim;
    }

    public void setCarTrim(String carTrim) {
        this.carTrim = carTrim;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public String getCarYear() {
        return carYear;
    }

    public void setCarYear(String carYear) {
        this.carYear = carYear;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getTraction() {
        return traction;
    }

    public void setTraction(String traction) {
        this.traction = traction;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getExtColor() {
        return extColor;
    }

    public void setExtColor(String extColor) {
        this.extColor = extColor;
    }

    public String getDoors() {
        return doors;
    }

    public void setDoors(String doors) {
        this.doors = doors;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getCylinder() {
        return cylinder;
    }

    public void setCylinder(String cylinder) {
        this.cylinder = cylinder;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Object getUberType() {
        return uberType;
    }

    public void setUberType(Object uberType) {
        this.uberType = uberType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Double getSavings() {
        return savings;
    }

    public void setSavings(Double savings) {
        this.savings = savings;
    }

    public Double getFepm() {
        return fepm;
    }

    public void setFepm(Double fepm) {
        this.fepm = fepm;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAvgFuelConsumption() {
        return avgFuelConsumption;
    }

    public void setAvgFuelConsumption(String avgFuelConsumption) {
        this.avgFuelConsumption = avgFuelConsumption;
    }

    public StatusCar getStatus() {
        return status;
    }

    public void setStatus(String status) {
        switch (status){
            case "BOOKED":
                this.status = StatusCar.BOOKED;
                break;
            case "AVAILABLE":
                this.status = StatusCar.AVAILABLE;
                break;
            case "NEW_ARRIVAL":
                this.status = StatusCar.NEW_ARRIVAL;
                break;
            default:
                this.status = StatusCar.SOLD;
                break;

        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carName='" + carName + '\'' +
                ", carMake='" + carMake + '\'' +
                ", carModel='" + carModel + '\'' +
                ", carTrim='" + carTrim + '\'' +
                ", km='" + km + '\'' +
                ", carYear='" + carYear + '\'' +
                ", transmission='" + transmission + '\'' +
                ", traction='" + traction + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", extColor='" + extColor + '\'' +
                ", doors='" + doors + '\'' +
                ", seats='" + seats + '\'' +
                ", cylinder='" + cylinder + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", uberType=" + uberType +
                ", price=" + price +
                ", marketPrice=" + marketPrice +
                ", savings=" + savings +
                ", fepm=" + fepm +
                ", imageUrl='" + imageUrl + '\'' +
                ", avgFuelConsumption='" + avgFuelConsumption + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
