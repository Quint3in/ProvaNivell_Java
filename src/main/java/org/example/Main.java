package org.example;

import org.example.model.*;
import org.example.repository.RobotRepository;
import org.example.service.RobotService;
import org.example.ui.ResistanceReportPrinter;

import java.time.LocalDate;
import java.time.Year;

public class Main {
    public static void main(String[] args) {
        RobotRepository rp = new RobotRepository();
        RobotService rs = new RobotService(rp);

        AerialRobot aerialRobot1 = new AerialRobot("SkyDancer1","AeroDynamics",
                Year.of(2023), LocalDate.now(), 3000, 90);
        LandRobot landRobot1 = new LandRobot("TankBot1", "RoboCorp",Year.of(2022),
                LocalDate.now(), 40, TractionType.TRACKS);
        LandRobot landRobot2 = new LandRobot("TankBot2", "RoboCorp",Year.of(2022),
                LocalDate.now(), 30, TractionType.WHEELS);
        AquaticRobot aquaticRobot1 = new AquaticRobot("AquaRunner1","AquaTech",Year.of(2021),
                LocalDate.now(), 500, PropulsionType.PROPELLER);

        rs.addRobot(aerialRobot1);
        rs.addRobot(landRobot1);
        rs.addRobot(landRobot2);
        rs.addRobot(aquaticRobot1);

        rs.getRobotTechnicalDescriptions().forEach(System.out::println);
        System.out.println("---------------------------------------------------------");
        rs.getLandRobotsPerMinSpeed(31).forEach(robot -> System.out.println(robot.getTechnicalDescription()));
        System.out.println("---------------------------------------------------------");
        rs.getRobotsbyManufacturer("aquatech").forEach(robot -> System.out.println(robot.getTechnicalDescription()));

        ResistanceReportPrinter resistanceReportPrinter = new ResistanceReportPrinter();
        resistanceReportPrinter.printReport(rs.getResistanceEvaluableRobots());
    }
}