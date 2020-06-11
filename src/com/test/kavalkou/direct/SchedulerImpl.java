package com.test.kavalkou.direct;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SchedulerImpl implements Scheduler {
    @Override
    public List<Task> schedule(List<Task> tasks) {
        if (tasks.stream().noneMatch(t -> t.getPredecessors().isEmpty())) {
            throw new RuntimeException();
        }

        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getPredecessors().isEmpty()) {
                result.add(task);
            }
        }

        List<Task> checkList = new ArrayList<>(tasks);
        checkList.removeAll(result);

        int resultSize = result.size();
        for (int i = 0; i < tasks.size() - 1 - resultSize; i++) {
            List<String> names = result
                    .stream()
                    .map(Task::getName)
                    .collect(Collectors.toList());

            List<Task> nextTasks = checkList
                    .stream()
                    .filter(t -> names.containsAll(t.getPredecessors()))
                    .collect(Collectors.toList());
            result.addAll(nextTasks);
            checkList.removeAll(result);
        }

        if (result.size() != tasks.size()) {
            throw new RuntimeException();
        }
        return result;
    }
}
