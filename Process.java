public class Process {
    public int pid;
    public int arrivalTime;
    public int burstTime;
    public int remainingTime;
    public int memoryRequired;

    public int startTime = -1;
    public int endTime = -1;
    public int waitingTime = 0;
    public int turnaroundTime = 0;

    public Process(int pid, int arrivalTime, int burstTime, int memoryRequired) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.memoryRequired = memoryRequired;
    }
}
// This class represents a process in a scheduling and memory management system.
// It contains fields for process ID, arrival time, burst time, remaining time, and memory  
// required. It also includes fields for start time, end time, waiting time, and turnaround time.
// The constructor initializes these fields based on the provided parameters. This class can be 
// used in various scheduling algorithms and memory management strategies to track the state of processes
// throughout their lifecycle in a system. It is designed to be flexible for different scheduling   
// algorithms, such as First-Come-First-Serve (FCFS), Shortest Job First (SJF), or Round Robin,
// and can also be integrated with memory management systems to allocate and deallocate memory as needed.       
// The `remainingTime` field is particularly useful for preemptive scheduling algorithms, where the process may not complete in one go.