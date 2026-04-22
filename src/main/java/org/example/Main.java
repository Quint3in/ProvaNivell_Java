package org.example;

import org.example.model.*;
import org.example.repository.RobotRepository;
import org.example.service.RobotService;

import java.sql.Date;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        RobotRepository rp = new RobotRepository();
        RobotService rs = new RobotService(rp);

        AerialRobot aerialRobot1 = new AerialRobot("SkyDancer1","AeroDynamics",
                2023, Date.valueOf(LocalDate.now()), 3000, 90);
        LandRobot landRobot1 = new LandRobot("TankBot1", "RoboCorp",2022,
                Date.valueOf(LocalDate.now()), 40, TractionType.TRACKS);
        LandRobot landRobot2 = new LandRobot("TankBot2", "RoboCorp",2022,
                Date.valueOf(LocalDate.now()), 30, TractionType.WHEELS);
        AquaticRobot aquaticRobot1 = new AquaticRobot("AquaRunner1","AquaTech",2021,
                Date.valueOf(LocalDate.now()), 500, PropulsionType.PROPELLER);

        rs.addRobot(aerialRobot1);
        rs.addRobot(landRobot1);
        rs.addRobot(landRobot2);
        rs.addRobot(aquaticRobot1);

        rs.showRobotsTechnicalDescription();
        System.out.println("---------------------------------------------------------");
        rs.showLandRobotsPerMinSpeed(31);
        System.out.println("---------------------------------------------------------");
        rs.showRobotsbyManufacturer("aquatech");


    }
}