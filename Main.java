import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Process> processes = new ArrayList<>();

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Process " + (i + 1));
            System.out.print("Arrival Time: ");
            int at = sc.nextInt();
            System.out.print("Burst Time: ");
            int bt = sc.nextInt();
            System.out.print("Memory Required: ");
            int mem = sc.nextInt();

            processes.add(new Process(i + 1, at, bt, mem));
        }

        System.out.print("Choose Scheduling (fcfs): ");
        String scheduling = sc.next().toLowerCase();

        System.out.print("Choose Memory Allocation (first/best): ");
        String memStrategy = sc.next().toLowerCase();

        MemoryManager mm = new MemoryManager(1024);
        for (Process p : processes) {
            if (!mm.allocate(p.pid, p.memoryRequired, memStrategy)) {
                System.out.println("Memory allocation failed for PID " + p.pid);
            }
        }

        if (scheduling.equals("fcfs")) {
            Scheduler.fcfs(processes);
        }

        System.out.println("\nResults:");
        for (Process p : processes) {
            System.out.println("PID " + p.pid + ": Waiting = " + p.waitingTime + ", Turnaround = " + p.turnaroundTime);
        }

        sc.close();
    }
}
// This is the main class that initializes the process list, takes user input for process details,
// scheduling algorithm, and memory allocation strategy. It uses the `MemoryManager` to allocate memory         
// for each process and then applies the chosen scheduling algorithm (FCFS in this case). Finally, it prints
// the waiting time and turnaround time for each process. This class serves as the entry point for the scheduling
// and memory management system, allowing users to interactively test different configurations and observe the results. 