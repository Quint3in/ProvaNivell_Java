package org.example;

import org.example.model.*;
import org.example.repository.RobotRepository;
import org.example.service.RobotService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobotServiceTest {

    private final RobotRepository robotRepository = new RobotRepository();
    private final RobotService robotService = new RobotService(robotRepository);

    private Robot landRobot1;
    private Robot landRobot2;
    private Robot aerialRobot1;
    private Robot aquaticRobot1;

    @BeforeEach
    void setUp() {
        landRobot1 = new LandRobot("TankBot1", "RoboCorp",Year.of(2022),
                LocalDate.now(), 40, TractionType.TRACKS);
        landRobot2 = new LandRobot("TankBot2", "RoboCorp",Year.of(2022),
                LocalDate.now(), 30, TractionType.WHEELS);
        aerialRobot1 = new AerialRobot("SkyDancer1","AeroDynamics",
                Year.of(2023), LocalDate.now(), 3000, 90);
        aquaticRobot1 = new AquaticRobot("AquaRunner1","AquaTech",Year.of(2021),
                LocalDate.now(), 500, PropulsionType.PROPELLER);

        robotRepository.saveRobot(aerialRobot1);
        robotRepository.saveRobot(landRobot1);
        robotRepository.saveRobot(landRobot2);
        robotRepository.saveRobot(aquaticRobot1);
    }

    @Test
    void getRobotTechnicalDescriptionsTest() {
        List<String> technicalDescriptions = new ArrayList<>();
        technicalDescriptions.add("SkyDancer1 vuela hasta 3000 m durante 90 minutos. Fabricado en 2023 por AeroDynamics.");
        technicalDescriptions.add("TankBot1, fabricado por RoboCorp en 2022, usa tracción tracks y alcanza hasta 40 km/h.");
        technicalDescriptions.add("TankBot2, fabricado por RoboCorp en 2022, usa tracción wheels y alcanza hasta 30 km/h.");
        technicalDescriptions.add("AquaRunner1 alcanza una profundidad de 500 m con propulsión tipo propeller. Fabricado por AquaTech en 2021.");

        assertEquals(robotService.getRobotTechnicalDescriptions(),technicalDescriptions);
    }

    @Test
    void getLandRobotsPerMinSpeedTest() {
        List<Robot> minSpeedRobots = new ArrayList<>();
        minSpeedRobots.add(landRobot1);

        assertEquals(robotService.getLandRobotsPerMinSpeed(35),minSpeedRobots);
    }

    @Test
    void getRobotsByManufacturerTest() {
        List<Robot> robotsByManufacturer = new ArrayList<>();
        robotsByManufacturer.add(landRobot1);
        robotsByManufacturer.add(landRobot2);

        assertEquals(robotService.getRobotsbyManufacturer("RoboCorp"),robotsByManufacturer);
    }

    @Test
    void getResistanceEvaluableRobotsTest() {
        List<ResistanceEvaluable> resistantEvaluableRobots = new ArrayList<>();
        resistantEvaluableRobots.add( (ResistanceEvaluable) aerialRobot1);
        resistantEvaluableRobots.add( (ResistanceEvaluable) landRobot1);
        resistantEvaluableRobots.add( (ResistanceEvaluable) landRobot2);

        assertEquals(robotService.getResistanceEvaluableRobots(),resistantEvaluableRobots);
    }
}
