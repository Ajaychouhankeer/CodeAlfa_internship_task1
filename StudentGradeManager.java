package StudentGradeManagement;

import java.util.ArrayList;
import java.util.Scanner;
	
public class StudentGradeManager {
    private ArrayList<Double> grades;
    private Scanner scanner;

    public StudentGradeManager() {
        grades = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void inputGrades() {
        while (true) {
            System.out.print("Enter a grade (or -1 to finish): ");
            double grade = scanner.nextDouble();
            if (grade == -1) {
                break;
            }
            grades.add(grade);
        }
    }

    public double calculateAverage() {
        if (grades.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public double findHighestScore() {
        if (grades.isEmpty()) {
            return 0;
        }
        double highest = grades.get(0);
        for (double grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    public double findLowestScore() {
        if (grades.isEmpty()) {
            return 0;
        }
        double lowest = grades.get(0);
        for (double grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }

    public void displayResults() {
        System.out.println("\nResults:");
        System.out.printf("Average Score: %.2f\n", calculateAverage());
        System.out.printf("Highest Score: %.2f\n", findHighestScore());
        System.out.printf("Lowest Score: %.2f\n", findLowestScore());
    }

    public static void main(String[] args) {
        StudentGradeManager manager = new StudentGradeManager();
        System.out.println("Welcome to the Student Grade Manager");
        manager.inputGrades();
        manager.displayResults();
    }
}