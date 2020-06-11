package com.test.kavalkou.direct;

import java.util.List;

public class Task {

    private String name;
    private List<String> predecessors;

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
}
