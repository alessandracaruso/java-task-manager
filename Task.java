public class Task {
    String title;
    String description;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String display() {
        return "Titolo: " + title + " | Descrizione: " + description;
    }
}
