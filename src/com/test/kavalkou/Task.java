package com.test.kavalkou;

import java.util.List;

public class Task {

    private String name;
    private List<String> predecessors;

    //no other ideas
    private boolean isVisited = false;

    public Task(String name, List<String> predecessors) {
        this.name = name;
        this.predecessors = predecessors;
    }

    public String getName() {
        return name;
    }

    public List<String> getPredecessors() {
        return predecessors;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public boolean isVisited() {
        return isVisited;
    }
}
