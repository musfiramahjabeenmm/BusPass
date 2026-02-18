import model.PassType;
import service.BusPassService;

import java.util.Scanner;

public class BusPassApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BusPassService service = new BusPassService();

        while (true) {
            System.out.println("\n=== BUS PASS MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Passenger");
            System.out.println("2. Issue Pass");
            System.out.println("3. Renew Pass");
            System.out.println("4. Cancel Pass");
            System.out.println("5. View All Passes");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter passenger name: ");
                        scanner.nextLine();
                        String name = scanner.nextLine();
                        System.out.println("Passenger added with ID: "
                                + service.addPassenger(name).getId());
                        break;

                    case 2:
                        System.out.print("Passenger ID: ");
                        Long pid = scanner.nextLong();
                        scanner.nextLine();

                        System.out.print("Route: ");
                        String route = scanner.nextLine();

                        System.out.println("Pass Type (STUDENT / MONTHLY / SENIOR_CITIZEN): ");
                        PassType type = PassType.valueOf(scanner.nextLine().toUpperCase());

                        System.out.println("Pass issued with ID: "
                                + service.issuePass(pid, route, type).getId());
                        break;

                    case 3:
                        System.out.print("Enter Pass ID: ");
                        service.renewPass(scanner.nextLong());
                        System.out.println("Pass renewed successfully.");
                        break;

                    case 4:
                        System.out.print("Enter Pass ID: ");
                        service.cancelPass(scanner.nextLong());
                        System.out.println("Pass cancelled successfully.");
                        break;

                    case 5:
                        service.viewAllPasses();
                        break;

                    case 6:
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
