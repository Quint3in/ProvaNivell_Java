package org.example.service;

import org.example.model.ResistanceEvaluable;
import org.example.repository.RobotRepository;
import org.example.model.LandRobot;
import org.example.model.Robot;

import java.util.List;

public class RobotService {

    private final RobotRepository robotRepository;

    public RobotService(RobotRepository robotRepository) {
        this.robotRepository = robotRepository;
    }
    public void addRobot(Robot robot) {
        this.robotRepository.saveRobot(robot);
    }
    public Robot removeLastRobot() {
        return this.robotRepository.deleteLastRobot();
    }

    public List<String> getRobotTechnicalDescriptions() {
        return this.robotRepository.getRobots().stream()
                .map(Robot::getTechnicalDescription)
                .toList();
    }

    public List<Robot> getLandRobotsPerMinSpeed(int minSpeed) {
        return this.robotRepository.getRobots().stream()
                .filter(robot -> {
                    if (robot instanceof LandRobot landRobot1) {
                        return landRobot1.getMaxSpeedKmH() >= minSpeed;
                    }
                    return false;
                }).toList();
    }

    public List<Robot> getRobotsbyManufacturer(String manufacturer) {
        return this.robotRepository.getRobots().stream()
                .filter(robot -> robot.getManufacturer().equalsIgnoreCase(manufacturer))
                .toList();
    }

    public List<ResistanceEvaluable> getResistanceEvaluableRobots() {
        return this.robotRepository.getRobots().stream()
                .filter(robot -> robot instanceof ResistanceEvaluable)
                .map(robot -> (ResistanceEvaluable) robot)
                .toList();
    }
}
