package com.test.kavalkou.recursive;

import java.util.*;

public class SchedulerImpl implements Scheduler {
    private List<Task> allTasks;
    private Queue<Task> queue;

    @Override
    public List<Task> schedule(List<Task> tasks) {
        allTasks = tasks;
        queue = new LinkedList<>();
        sort(tasks);
        return new ArrayList<>(queue);
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
                queue.add(singleTask);
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
