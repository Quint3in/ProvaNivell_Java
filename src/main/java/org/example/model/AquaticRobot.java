package org.example.model;

import java.util.Date;

public class AquaticRobot extends Robot{

    private int maxDepthMeters;
    private PropulsionType propulsionType;

    public AquaticRobot(String name, String manufacturer, int manufacturingYear, Date competitionRegisterDate,
                        int maxDepthMeters, PropulsionType propulsionType)
    {
        super(name, manufacturer, manufacturingYear, competitionRegisterDate);
        this.maxDepthMeters = maxDepthMeters;
        this.propulsionType = propulsionType;
    }

    @Override
    public String getTechnicalDescription() {
        return name+ " alcanza una profundidad de "+maxDepthMeters+" m con propulsión tipo "
                +String.valueOf(propulsionType).toLowerCase()+". Fabricado por "+manufacturer+" en "+manufacturingYear+".";
    }
}
