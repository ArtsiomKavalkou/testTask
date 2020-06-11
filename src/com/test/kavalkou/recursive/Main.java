package com.test.kavalkou.recursive;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Task> tasks = Arrays.asList(
                new Task("E", Arrays.asList("B")),
                new Task("D", Arrays.asList("A", "B")),
                new Task("A", Arrays.asList()),
                new Task("B", Arrays.asList("A")),
                new Task("C", Arrays.asList("D", "B")),
                new Task("F", Arrays.asList("E"))
        );

        Scheduler scheduler = new SchedulerImpl();
        List<Task> sortedTasks = scheduler.schedule(tasks);

        for (Task task : sortedTasks) {
            System.out.println(task.getName());
        }
    }
}
