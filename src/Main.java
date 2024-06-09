import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int index = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("User:");
        String user = scanner.nextLine();
        System.out.println("Password:");
        String password = scanner.nextLine();
        DatabaseConnection dbConnection = new DatabaseConnection(user, password);
        while (true) {
            System.out.println("Was möchten Sie machen?");
            System.out.println("1: Personal anlegen");
            System.out.println("2: Insassen anlegen");
            System.out.println("3: Personal und Insassen verknüpfen");
            System.out.println("4: Zelle registrieren");
            System.out.println("5: Insasse mit Zelle verknüpfen");
            System.out.println("6: Insassen in File Exporten");
            System.out.println("7: Insassen entlassen");
            System.out.println("8: Insassen aus File importieren");
            index = scanner.nextInt();
            if (index == 1) {
                String name;
                String surname;
                int age;
                String safetyLevel;
                System.out.println("Vorname:");
                name = scanner.next();
                System.out.println("Nachname:");
                surname = scanner.next();
                System.out.println("Alter:");
                age = scanner.nextInt();
                System.out.println("Sicherheitsstufe: (Sicher, Sehr sicher, Sicherheitsprofi)");
                safetyLevel = scanner.next();
                dbConnection.createPersonal(name, surname, age, safetyLevel);
            }
            if (index == 2) {
                String name;
                String surname;
                int age;
                int crimeLevel;
                String crime;
                int years;
                System.out.println("Vorname:");
                name = scanner.next();
                System.out.println("Nachname:");
                surname = scanner.next();
                System.out.println("Alter:");
                age = scanner.nextInt();
                System.out.println("Verbrechenslevel (0-3):");
                crimeLevel = scanner.nextInt();
                System.out.println("Verbrechen:");
                crime = scanner.next();
                System.out.println("Verurteilte Jahre:");
                years = scanner.nextInt();
                dbConnection.createInsassen(name, surname, age, crimeLevel, crime, years);
            }
            if (index == 3) {

                dbConnection.createperosnal_insassenrel();
            }
            if (index == 4) {
                System.out.println("Eine neue Zelle wurde gebaut");
                int platzanzahl = 0;
                dbConnection.createZelle(platzanzahl);
            }
            if (index == 5) {
                dbConnection.createZelleinsasse();
            }
            if (index == 6) {
                dbConnection.exportInsassen();
            }
            if (index == 7) {
                dbConnection.entlassenInsassen();
            }
            if (index == 8) {
                dbConnection.importInsassen();
            }
        }
    }
}