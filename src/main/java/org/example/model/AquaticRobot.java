package org.example.model;

import java.time.LocalDate;
import java.time.Year;

public class AquaticRobot extends Robot {

    private final int maxDepthMeters;
    private final PropulsionType propulsionType;

    public AquaticRobot(String name, String manufacturer, Year manufacturingYear, LocalDate competitionRegisterDate,
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
