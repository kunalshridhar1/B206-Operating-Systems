import java.util.List;

public class Metrics {
    public static void printAverages(List<Process> list) {
        double totalWT = 0, totalTAT = 0;
        for (Process p : list) {
            totalWT += p.waitingTime;
            totalTAT += p.turnaroundTime;
        }

        System.out.println("\nAverage Waiting Time: " + (totalWT / list.size()));
        System.out.println("Average Turnaround Time: " + (totalTAT / list.size()));
    }
}
// This class calculates and prints the average waiting time and turnaround time for a list of processes.
// It iterates through the list of processes, sums up their waiting times and turnaround times,     
// and then divides by the number of processes to get the averages. This is useful for evaluating the performance
// of scheduling algorithms and memory management strategies in a system. The results can help identify bottlenecks
// and areas for improvement in process scheduling and resource allocation. The `printAverages` method      
// is designed to be called after the scheduling and memory management operations have been performed,
// providing a summary of the overall performance metrics for the processes involved. It is a simple yet    
// effective way to assess the efficiency of the scheduling algorithm used in the system.