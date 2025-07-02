# 🖥️ Java Operating Systems Simulator

This project simulates key components of an operating system, including **process scheduling**, **memory management**, and **system performance metrics** using Java.

---

## Features

- ✅ **Process Scheduling Algorithms**
  - FCFS (First-Come-First-Served)
  - SJF (Shortest Job First - Non-preemptive)
  - Round Robin (Preemptive with time quantum)

- ✅ **Memory Allocation Techniques**
  - First-Fit
  - Best-Fit

- ✅ **System Metrics**
  - Waiting Time
  - Turnaround Time
  - CPU Time Tracking (optional)
  - Memory Allocation Summary

- ✅ **Command Line Interface**
  - Simple CLI to enter process info and choose strategies

---

## 🛠️ How to Compile & Run

### 🧑‍💻 Requirements
- Java JDK 17 or higher
- VS Code or any Java IDE (IntelliJ, Eclipse, etc.)

### 🔧 Compile
```bash
javac *.java



▶️ Run

    java Main



📥 Sample Input

    Enter number of processes: 3

    Process 1
    Arrival Time: 0
    Burst Time: 5
    Memory Required: 10

    Process 2
    Arrival Time: 1
    Burst Time: 3
    Memory Required: 15

    Process 3
    Arrival Time: 2
    Burst Time: 1
    Memory Required: 5

    Choose Scheduling (fcfs/sjf/rr): sjf
    Choose Memory Allocation (first/best): best


📤 Sample Output

    Results:
    PID 1: Waiting = 4, Turnaround = 9
    PID 2: Waiting = 0, Turnaround = 3
    PID 3: Waiting = 2, Turnaround = 3

    Average Waiting Time: 2.00
    Average Turnaround Time: 5.00


📦 Project Structure
    .
    ├── Main.java              # CLI + project controller
    ├── Process.java           # Process class definition
    ├── Scheduler.java         # FCFS, SJF, RR scheduling
    ├── MemoryManager.java     # First-Fit / Best-Fit allocator
    ├── Metrics.java           # Utility for system statistics



📘 Concepts Implemented 

    🧠 OS Scheduling Algorithms

    📦 Dynamic Memory Allocation

    📊 System Metrics Tracking

    🧾 Queue Management & CPU Simulation

    🧑‍💻 Interactive CLI Input



📌 Future Enhancements 
 
    ✅ Gantt Chart Output

    ✅ File-based input/output

    🔄 Preemptive SJF

    📈 CPU utilization % and memory usage stats



👨‍💻 Author
Kunal Shridhar
📧 shridharkunal2005@gmail.com
🔗 GitHub:kunalshridhar1