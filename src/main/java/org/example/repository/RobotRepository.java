package org.example.repository;

import org.example.model.Robot;

import java.util.ArrayList;
import java.util.List;

public class RobotRepository {

    private final List<Robot> robots;

    public RobotRepository() {
        this.robots = new ArrayList<>();
    }
    public List<Robot> getRobots() {
        return new ArrayList<>(robots);
    }
    public void saveRobot(Robot robot) {
        this.robots.add(robot);
    }
    public Robot deleteLastRobot() {
        return this.robots.removeLast();
    }
}
