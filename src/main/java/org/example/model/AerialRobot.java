package org.example.model;

import java.util.Date;

public class AerialRobot extends Robot{

    private int maxHeightMeters;
    private int flightEnduranceMinutes;

    public AerialRobot(String name, String manufacturer, int manufacturingYear, Date competitionRegisterDate,
                       int maxHeightMeters, int flightEnduranceMinutes)
    {
        super(name, manufacturer, manufacturingYear, competitionRegisterDate);
        this.maxHeightMeters = maxHeightMeters;
        this.flightEnduranceMinutes = flightEnduranceMinutes;
    }

    @Override
    public String getTechnicalDescription() {
        return name+" vuela hasta "+maxHeightMeters+" m durante "+flightEnduranceMinutes+" minutos. Fabricado en "+manufacturingYear+" por "+manufacturer+".";
    }

}
