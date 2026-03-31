import java.util.ArrayList;
import java.util.Scanner;

// Classe che rappresenta un singolo task
class Task {
    String titolo;
    String descrizione;
    String owner;

    public Task(String titolo, String descrizione, String owner) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.owner = owner;
    }

    // Metodo per visualizzare il task in modo leggibile
    public String display() {
        return "Titolo: " + titolo + "\nDescrizione: " + descrizione + "\nOwner: " + owner;
    }
}

public class TaskManager {
    // Flag per attivare o disattivare il debug
    private static final boolean DEBUG_MODE = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        boolean running = true;

        while (running) {
            System.out.println("\n--- TASK MANAGER ---");
            System.out.println("1. Aggiungi task");
            System.out.println("2. Visualizza task");
            System.out.println("3. Modifica task");
            System.out.println("4. Cancella task");
            System.out.println("5. Esci");
            System.out.print("Scegli un'opzione: ");

            String input = scanner.nextLine();
            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Inserisci un numero valido!");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    // Aggiungi task
                    System.out.print("Inserisci il titolo del task: ");
                    String titolo = scanner.nextLine();
                    System.out.print("Inserisci la descrizione del task: ");
                    String descrizione = scanner.nextLine();
                    System.out.print("Inserisci l'owner del task: ");
                    String owner = scanner.nextLine();

                    Task task = new Task(titolo, descrizione, owner);
                    tasks.add(task);
                    System.out.println("Task aggiunto!");

                    if (DEBUG_MODE) {
                        System.out.println("DEBUG:");
                        tasks.forEach(t -> System.out.println("- " + t.display()));
                    }
                }
                case 2 -> {
                    // Visualizza task
                    if (tasks.isEmpty()) {
                        System.out.println("Nessun task presente.");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println("Task " + (i + 1) + ":\n" + tasks.get(i).display() + "\n");
                        }
                    }
                }
                case 3 -> {
                    // Modifica task
                    if (tasks.isEmpty()) {
                        System.out.println("Nessun task da modificare.");
                        continue;
                    }
                    System.out.print("Inserisci il numero del task da modificare: ");
                    int idx;
                    try {
                        idx = Integer.parseInt(scanner.nextLine()) - 1;
                        if (idx < 0 || idx >= tasks.size()) throw new IndexOutOfBoundsException();
                    } catch (Exception e) {
                        System.out.println("Numero non valido!");
                        continue;
                    }

                    Task t = tasks.get(idx);
                    System.out.print("Nuovo titolo (" + t.titolo + "): ");
                    String newTitolo = scanner.nextLine();
                    System.out.print("Nuova descrizione (" + t.descrizione + "): ");
                    String newDescrizione = scanner.nextLine();
                    System.out.print("Nuovo owner (" + t.owner + "): ");
                    String newOwner = scanner.nextLine();

                    if (!newTitolo.isEmpty()) t.titolo = newTitolo;
                    if (!newDescrizione.isEmpty()) t.descrizione = newDescrizione;
                    if (!newOwner.isEmpty()) t.owner = newOwner;

                    System.out.println("Task modificato!");

                    if (DEBUG_MODE) {
                        System.out.println("DEBUG:");
                        tasks.forEach(task -> System.out.println("- " + task.display()));
                    }
                }
                case 4 -> {
                    // Cancella task
                    if (tasks.isEmpty()) {
                        System.out.println("Nessun task da cancellare.");
                        continue;
                    }
                    System.out.print("Inserisci il numero del task da cancellare: ");
                    int idx;
                    try {
                        idx = Integer.parseInt(scanner.nextLine()) - 1;
                        if (idx < 0 || idx >= tasks.size()) throw new IndexOutOfBoundsException();
                    } catch (Exception e) {
                        System.out.println("Numero non valido!");
                        continue;
                    }
                    tasks.remove(idx);
                    System.out.println("Task cancellato!");

                    if (DEBUG_MODE) {
                        System.out.println("DEBUG:");
                        tasks.forEach(task -> System.out.println("- " + task.display()));
                    }
                }
                case 5 -> {
                    // Esci
                    running = false;
                    System.out.println("Uscita dal programma.");
                }
                default -> System.out.println("Scelta non valida.");
            }
        }

        scanner.close();
    }
}
