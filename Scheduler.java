import java.util.*;

public class Scheduler {

    public static List<Process> fcfs(List<Process> processes) {
        processes.sort(Comparator.comparingInt(p -> p.arrivalTime));
        int currentTime = 0;
        for (Process p : processes) {
            if (currentTime < p.arrivalTime) currentTime = p.arrivalTime;
            p.startTime = currentTime;
            currentTime += p.burstTime;
            p.endTime = currentTime;
            p.waitingTime = p.startTime - p.arrivalTime;
            p.turnaroundTime = p.endTime - p.arrivalTime;
        }
        return processes;
    }

    public static List<Process> sjf(List<Process> processes) {
        List<Process> completed = new ArrayList<>();
        List<Process> queue = new ArrayList<>();
        int currentTime = 0;

        while (completed.size() < processes.size()) {
            for (Process p : processes) {
                if (p.arrivalTime <= currentTime && !completed.contains(p) && !queue.contains(p)) {
                    queue.add(p);
                }
            }

            if (queue.isEmpty()) {
                currentTime++;
                continue;
            }

            queue.sort(Comparator.comparingInt(p -> p.burstTime));
            Process current = queue.remove(0);

            current.startTime = currentTime;
            currentTime += current.burstTime;
            current.endTime = currentTime;
            current.waitingTime = current.startTime - current.arrivalTime;
            current.turnaroundTime = current.endTime - current.arrivalTime;

            completed.add(current);
        }

        return completed;
    }

    public static List<Process> roundRobin(List<Process> processes, int quantum) {
        Queue<Process> queue = new LinkedList<>();
        List<Process> completed = new ArrayList<>();
        int currentTime = 0;
        int n = processes.size();

        processes.sort(Comparator.comparingInt(p -> p.arrivalTime));
        int index = 0;

        while (completed.size() < n) {
            while (index < n && processes.get(index).arrivalTime <= currentTime) {
                queue.offer(processes.get(index++));
            }

            if (queue.isEmpty()) {
                currentTime++;
                continue;
            }

            Process current = queue.poll();

            if (current.startTime == -1) current.startTime = currentTime;

            int execTime = Math.min(quantum, current.remainingTime);
            currentTime += execTime;
            current.remainingTime -= execTime;

            while (index < n && processes.get(index).arrivalTime <= currentTime) {
                queue.offer(processes.get(index++));
            }

            if (current.remainingTime > 0) {
                queue.offer(current);
            } else {
                current.endTime = currentTime;
                current.turnaroundTime = current.endTime - current.arrivalTime;
                current.waitingTime = current.turnaroundTime - current.burstTime;
                completed.add(current);
            }
        }

        completed.sort(Comparator.comparingInt(p -> p.pid));
        return completed;
    }
}
// This class implements various scheduling algorithms such as First-Come, First-Served (FCFS),
// Shortest Job First (SJF), and Round Robin. Each method takes a list of              
// `Process` objects, sorts them based on their arrival times, and calculates the start time,
// end time, waiting time, and turnaround time for each process. The results are returned as
// a list of `Process` objects with updated timing information. The class serves as a utility for
// scheduling processes based on different algorithms, allowing for flexible process management in a system.