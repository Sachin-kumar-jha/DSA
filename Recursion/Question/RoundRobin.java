package Recursion.Question;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Process {
    int id, burstTime, remainingTime, arrivalTime, waitTime, turnaroundTime;

    public Process(int id, int arrivalTime, int burstTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.waitTime = 0;
        this.turnaroundTime = 0;
    }
}

public class RoundRobin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of processes
        System.out.print("Enter the number of processes: ");
        int numProcesses = sc.nextInt();

        // Input the time quantum
        System.out.print("Enter the time quantum: ");
        int timeQuantum = sc.nextInt();

        // Input arrival and burst times for each process
        Queue<Process> queue = new LinkedList<>();
        for (int i = 0; i < numProcesses; i++) {
            System.out.print("Enter arrival time for process P" + (i + 1) + ": ");
            int arrivalTime = sc.nextInt();
            System.out.print("Enter burst time for process P" + (i + 1) + ": ");
            int burstTime = sc.nextInt();
            queue.add(new Process(i + 1, arrivalTime, burstTime));
        }

        // Variables for total time, waiting time, and turnaround time
        int totalTime = 0;
        int totalWaitTime = 0;
        int totalTurnaroundTime = 0;
        Queue<Process> readyQueue = new LinkedList<>();
        
        // Round Robin Scheduling considering arrival time
        while (!queue.isEmpty() || !readyQueue.isEmpty()) {
            // Add processes to the ready queue based on arrival time
            while (!queue.isEmpty() && queue.peek().arrivalTime <= totalTime){
                readyQueue.add(queue.poll());
            }

            if (!readyQueue.isEmpty()) {
                Process currentProcess = readyQueue.poll();
                if (currentProcess.remainingTime > timeQuantum) {
                    totalTime += timeQuantum;
                    currentProcess.remainingTime -= timeQuantum;
                    // Re-add to the ready queue after running for the quantum
                    readyQueue.add(currentProcess);
                } else {
                    totalTime += currentProcess.remainingTime;
                    currentProcess.waitTime = totalTime - currentProcess.arrivalTime - currentProcess.burstTime;
                    currentProcess.turnaroundTime = totalTime - currentProcess.arrivalTime;
                    totalWaitTime += currentProcess.waitTime;
                    totalTurnaroundTime += currentProcess.turnaroundTime;

                    System.out.println("Process P" + currentProcess.id + " finished.");
                    System.out.println("Waiting time: " + currentProcess.waitTime);
                    System.out.println("Turnaround time: " + currentProcess.turnaroundTime);
                }
            } else {
                // If no process is ready, just advance time to the next process arrival
                if (!queue.isEmpty()) {
                    totalTime = queue.peek().arrivalTime;
                }
            }
        }

        // Output average waiting and turnaround times
        double avgWaitTime = (double) totalWaitTime / numProcesses;
        double avgTurnaroundTime = (double) totalTurnaroundTime / numProcesses;

        System.out.println("\nAverage Waiting Time: " + avgWaitTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
    }
}

