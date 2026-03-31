import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {

    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    running = false;
                    System.out.println("Uscita...");
                    break;
                default:
                    System.out.println("Scelta non valida");
            }
        }
    }

    public static void printMenu() {
        System.out.println("\n--- TASK MANAGER ---");
        System.out.println("1. Aggiungi task");
        System.out.println("2. Visualizza task");
        System.out.println("3. Elimina task");
        System.out.println("4. Esci");
        System.out.print("Scelta: ");
    }

    public static void addTask() {
        System.out.print("Titolo: ");
        String title = scanner.nextLine();

        System.out.print("Descrizione: ");
        String description = scanner.nextLine();

        Task newTask = new Task(title, description);
        tasks.add(newTask);

        System.out.println("Task aggiunto!");
    }

    public static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Nessun task.");
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i).display());
        }
    }

    public static void deleteTask() {
        viewTasks();

        if (tasks.isEmpty()) return;

        System.out.print("Numero task da eliminare: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index > 0 && index <= tasks.size()) {
            tasks.remove(index - 1);
            System.out.println("Task eliminato!");
        } else {
            System.out.println("Indice non valido");
        }
    }
}
