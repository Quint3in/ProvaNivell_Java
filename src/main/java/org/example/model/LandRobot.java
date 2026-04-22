package org.example.model;

import java.util.Date;

public class LandRobot extends Robot{

    private final int maxSpeedKmH;
    private final TractionType tractionType;

    public LandRobot(String name, String manufacturer, int manufacturingYear, Date competitionRegisterDate,
                     int maxSpeedKmH, TractionType tractionType)
    {
        super(name, manufacturer, manufacturingYear, competitionRegisterDate);
        this.maxSpeedKmH = maxSpeedKmH;
        this.tractionType = tractionType;
    }

    @Override
    public String getTechnicalDescription() {
        return name+", fabricado por "+manufacturer+" en "+manufacturingYear+", usa tracción "
                +String.valueOf(tractionType).toLowerCase()+" y alcanza hasta "+maxSpeedKmH+" km/h.";
    }

    public int getMaxSpeedKmH() {
        return maxSpeedKmH;
    }
}
