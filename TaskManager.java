import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();

        boolean running = true;

        while (running) {
            System.out.println("\n--- TASK MANAGER ---");
            System.out.println("1. Aggiungi task");
            System.out.println("2. Visualizza task");
            System.out.println("3. Esci");
            System.out.print("Scegli un'opzione: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // pulisce buffer

            if (choice == 1) {
                System.out.print("Inserisci il task: ");
                String task = scanner.nextLine();
                tasks.add(task);
                System.out.println("Task aggiunto!");
            } else if (choice == 2) {
                System.out.println("\nLista task:");
                if (tasks.isEmpty()) {
                    System.out.println("Nessun task presente.");
                } else {
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i));
                    }
                }
            } else if (choice == 3) {
                running = false;
                System.out.println("Uscita dal programma.");
            } else {
                System.out.println("Scelta non valida.");
            }
        }

        scanner.close();
    }
}