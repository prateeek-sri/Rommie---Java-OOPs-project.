import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RoommateFinder finder = new RoommateFinder();

        finder.loadRoomsFromFile();

        System.out.println("1. Add a Room\n2. Add a Roommate\n3. Exit");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            System.out.println("Enter Room Details:");

            System.out.print("Location: ");
            String location = scanner.nextLine();

            System.out.print("Rent: ");
            double rent = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            System.out.print("Room Type (e.g., single, shared, suite): ");
            String roomType = scanner.nextLine();

            System.out.print("Size (small/medium/large): ");
            String size = scanner.nextLine();

            System.out.print("Available (yes/no): ");
            boolean isAvailable = scanner.nextLine().equalsIgnoreCase("yes");

            System.out.print("Gender Preference (male/female/any): ");
            String genderPreference = scanner.nextLine();

            System.out.print("Lease Period (e.g., 6 months, 1 year): ");
            String leasePeriod = scanner.nextLine();

            System.out.print("Pet Friendly (yes/no): ");
            boolean petFriendly = scanner.nextLine().equalsIgnoreCase("yes");

            Room room = new Room(location, rent, roomType, size, isAvailable, genderPreference, leasePeriod, petFriendly);
            finder.addRoom(room);
            finder.saveRoomsToFile();
        } else if (choice == 2) {
            System.out.println("Enter Your Details:");

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Budget: ");
            double budget = scanner.nextDouble();
            scanner.nextLine();  // Consume newline

            System.out.print("Gender (male/female/any): ");
            String gender = scanner.nextLine();

            System.out.print("Preferred Room Type (e.g., single, shared, suite): ");
            String preferredRoomType = scanner.nextLine();

            System.out.print("Preferred Location: ");
            String preferredLocation = scanner.nextLine();

            System.out.print("Lease Period (e.g., 6 months, 1 year): ");
            String leasePeriod = scanner.nextLine();

            System.out.print("Pet Friendly (yes/no): ");
            boolean petFriendly = scanner.nextLine().equalsIgnoreCase("yes");

            User user = new User(name, age, budget, gender, preferredRoomType, preferredLocation, leasePeriod, petFriendly);
            finder.findBestMatch(user);
        } else {
            System.out.println("Exiting...");
        }

        scanner.close();
    }
}
