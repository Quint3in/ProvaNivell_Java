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
        return robots;
    }
}
