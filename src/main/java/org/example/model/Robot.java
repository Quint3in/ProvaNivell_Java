package org.example.model;

import java.time.LocalDate;
import java.time.Year;

public abstract class Robot {
    protected final String name;
    protected final String manufacturer;
    protected final Year manufacturingYear;
    protected final LocalDate competitionRegisterDate;


    public Robot(String name, String manufacturer, Year manufacturingYear, LocalDate competitionRegisterDate) {
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
