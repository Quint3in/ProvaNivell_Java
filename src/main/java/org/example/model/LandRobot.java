package org.example.model;

import java.time.LocalDate;
import java.time.Year;

public class LandRobot extends Robot implements ResistanceEvaluable {

    private final int maxSpeedKmH;
    private final TractionType tractionType;

    public LandRobot(String name, String manufacturer, Year manufacturingYear, LocalDate competitionRegisterDate,
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

    @Override
    public String getResistanceReport() {
        String eligible = (tractionType == TractionType.TRACKS ? "confirmada. Apto para la competición." : "denegada. No cumple los requisitos.");
        return name+": tracción ORUGAS "+eligible;
    }
}
