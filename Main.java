import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of processes
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();
        List<Process> processList = new ArrayList<>();

        // Input process details
        for (int i = 0; i < n; i++) {
            System.out.println("Process " + (i + 1));
            System.out.print("Arrival Time: ");
            int arrival = sc.nextInt();
            System.out.print("Burst Time: ");
            int burst = sc.nextInt();
            System.out.print("Memory Required: ");
            int memory = sc.nextInt();
            processList.add(new Process(i + 1, arrival, burst, memory));
        }

        // Select scheduling algorithm
        System.out.print("Choose Scheduling (fcfs/sjf/rr): ");
        String schedType = sc.next();
        List<Process> result;

        if (schedType.equalsIgnoreCase("fcfs")) {
            result = Scheduler.fcfs(processList);
        } else if (schedType.equalsIgnoreCase("sjf")) {
            result = Scheduler.sjf(processList);
        } else if (schedType.equalsIgnoreCase("rr")) {
            System.out.print("Enter quantum time: ");
            int quantum = sc.nextInt();
            result = Scheduler.roundRobin(processList, quantum);
        } else {
            System.out.println("Invalid scheduling type!");
            return;
        }

        // Select memory allocation strategy
        System.out.print("Choose Memory Allocation (first/best): ");
        String memoryType = sc.next();
        MemoryManager memoryManager = new MemoryManager(1000); // 1000 MB total memory

        for (Process p : result) {
            boolean allocated = memoryManager.allocate(p.pid, p.memoryRequired, memoryType);
            if (!allocated) {
                System.out.println("Memory allocation failed for PID " + p.pid);
            }
        }

        // Display results
        System.out.println("\nResults:");
        for (Process p : result) {
            System.out.println("PID " + p.pid + ": Waiting = " + p.waitingTime + ", Turnaround = " + p.turnaroundTime);
        }
    }
}
// This code is the main entry point for a scheduling and memory management system in Java.
// It allows users to input process details such as arrival time, burst time, and memory requirements
// for a set of processes. The user can choose between different scheduling algorithms (FCFS, SJF, RR)  
// and memory allocation strategies (First-Fit, Best-Fit). The system then allocates memory to each process
// and calculates waiting and turnaround times. Finally, it displays the results for each process.  
// The code is designed to be interactive, allowing users to specify parameters and view results in a console application.
