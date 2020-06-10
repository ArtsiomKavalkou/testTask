package com.test.kavalkou;

import java.util.*;

public class SchedulerImpl implements Scheduler {
    private List<Task> allTasks;
    private Queue<Task> stack;

    @Override
    public List<Task> schedule(List<Task> tasks) {
        allTasks = tasks;
        stack = new LinkedList<>();
        sort(tasks);
        return new ArrayList<>(stack);
    }

    private void sort(List<Task> tasks) {
        for (Task singleTask : tasks) {
            List<String> predecessors = singleTask.getPredecessors();
            if (!singleTask.isVisited()) {
                List<Task> dependencies = new ArrayList<>();
                for (String predecessor : predecessors) {
                    Task taskByName = getTaskByName(predecessor);
                    if (taskByName != null) {
                        dependencies.add(taskByName);
                    }
                }
                sort(dependencies);

                singleTask.setVisited(true);
                stack.add(singleTask);
            }
        }
    }

    private Task getTaskByName(String taskName) {
        return allTasks
                .stream()
                .filter(task -> taskName.equals(task.getName()))
                .findAny().orElse(null);
    }
}
