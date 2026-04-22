package org.example.model;


import java.util.Date;

public abstract class Robot {
    protected final String name;
    protected final String manufacturer;
    protected final int manufacturingYear;
    protected final Date competitionRegisterDate;


    public Robot(String name, String manufacturer, int manufacturingYear, Date competitionRegisterDate) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.manufacturingYear = manufacturingYear;
        this.competitionRegisterDate = competitionRegisterDate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public abstract String getTechnicalDescription();

}
