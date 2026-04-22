package org.example.service;

import org.example.repository.RobotRepository;
import org.example.model.LandRobot;
import org.example.model.Robot;

public class RobotService {

    private final RobotRepository robotRepository;

    public RobotService(RobotRepository robotRepository) {
        this.robotRepository = robotRepository;
    }
    public boolean addRobot(Robot robot) {
        return this.robotRepository.getRobots().add(robot);
    }
    public Robot removeLastRobot() {
        return this.robotRepository.getRobots().removeLast();
    }

    public void showRobotsTechnicalDescription() {
        this.robotRepository.getRobots().forEach(robot -> System.out.println(robot.getTechnicalDescription()));
    }

    public void showLandRobotsPerMinSpeed(int minSpeed) {
        this.robotRepository.getRobots().stream()
                .filter(robot -> {
                    if (robot instanceof LandRobot) {
                        LandRobot landRobot1 = (LandRobot) robot;
                        return landRobot1.getMaxSpeedKmH() >= minSpeed;
                    }
                    return false;
                }).forEach(robot -> System.out.println(robot.getTechnicalDescription()));

    }

    public void showRobotsbyManufacturer(String manufacturer) {
        this.robotRepository.getRobots().stream()
                .filter(robot -> robot.getManufacturer().equalsIgnoreCase(manufacturer))
                .forEach(robot -> System.out.println(robot.getTechnicalDescription()));
    }
}
