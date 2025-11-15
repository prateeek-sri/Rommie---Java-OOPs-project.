import java.util.*;
import java.io.*;

public class RoommateFinder {

    private List<Room> rooms = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void saveRoomsToFile() {
        File directory = new File("data");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/rooms.txt", false))) {
            for (Room room : rooms) {
                writer.write(room.getLocation() + "," + room.getRent() + "," + room.getRoomType() + ","
                        + room.getSize() + "," + room.isAvailable() + "," + room.getGenderPreference() + ","
                        + room.getLeasePeriod() + "," + room.isPetFriendly());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving rooms to file.");
        }
    }

    public void loadRoomsFromFile() {
        File file = new File("data/rooms.txt");
        if (!file.exists()) {
            System.out.println("No existing rooms found in rooms.txt.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] roomData = line.split(",");
                String location = roomData[0];
                double rent = Double.parseDouble(roomData[1]);
                String roomType = roomData[2];
                String size = roomData[3];
                boolean isAvailable = Boolean.parseBoolean(roomData[4]);
                String genderPreference = roomData[5];
                String leasePeriod = roomData[6];
                boolean petFriendly = Boolean.parseBoolean(roomData[7]);
                rooms.add(new Room(location, rent, roomType, size, isAvailable, genderPreference, leasePeriod, petFriendly));
            }
        } catch (IOException e) {
            System.out.println("Error loading rooms from file.");
        }
    }

    public void findBestMatch(User user) {
        List<Room> matchedRooms = new ArrayList<>();
        
        for (Room room : rooms) {
            if (room.isAvailable() && room.getRent() <= user.getBudget()
                    && room.getRoomType().equalsIgnoreCase(user.getPreferredRoomType())
                    && room.getLocation().equalsIgnoreCase(user.getPreferredLocation())
                    && room.getGenderPreference().equalsIgnoreCase(user.getGender())) {
                matchedRooms.add(room);
            }
        }

        if (!matchedRooms.isEmpty()) {
            System.out.println("Found " + matchedRooms.size() + " matched room(s) for " + user.getName() + ":");
            for (int i = 0; i < matchedRooms.size(); i++) {
                Room room = matchedRooms.get(i);
                System.out.println("\nRoom " + (i + 1) + ":");
                room.printRoomDetails();
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter the number of the room you would like to choose, or 0 to cancel: ");
            int choice = scanner.nextInt();

            if (choice > 0 && choice <= matchedRooms.size()) {
                Room selectedRoom = matchedRooms.get(choice - 1);
                System.out.println("\nYou have selected the following room:");
                selectedRoom.printRoomDetails();

                rooms.remove(selectedRoom);
                saveRoomsToFile();
                System.out.println("The room is allotted and removed from the list.");
            } else {
                System.out.println("No valid selection made. Exiting.");
            }
            scanner.close();
        } else {
            System.out.println("No match found for " + user.getName() + ".");
        }
    }
}
