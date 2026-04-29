package org.example.model;

import java.time.LocalDate;
import java.time.Year;

public class AerialRobot extends Robot implements ResistanceEvaluable{

    private final int maxHeightMeters;
    private final int flightEnduranceMinutes;

    public AerialRobot(String name, String manufacturer, Year manufacturingYear, LocalDate competitionRegisterDate,
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

    @Override
    public String getResistanceReport() {
        String eligible = (flightEnduranceMinutes>=60 ? "Apto para la competición.": "No cumple los requisitos.");
        return name+": autonomía de "+flightEnduranceMinutes+" minutos." + eligible;
    }
}
