import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int index=0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("User:");
        String user=scanner.nextLine();
        System.out.println("Password:");
        String password=scanner.nextLine();
        DatabaseConnection dbConnection = new DatabaseConnection(user, password);
        System.out.println("Was möchten Sie machen?");
        System.out.println("1: Personal anlegen");
        index=scanner.nextInt();
        if(index==1) {
            String name;
            String surname;
            int age;
            String safetyLevel;
            System.out.println("Vorname:");
            name = scanner.nextLine();
            System.out.println("Nachname:");
            surname = scanner.nextLine();
            System.out.println("Alter:");
            age = scanner.nextInt();
            System.out.println("Sicherheitsstufe:");
            safetyLevel = scanner.nextLine();
            dbConnection.createPersonal("Max", "Mustermann", 42, "High");
        }
    }
}