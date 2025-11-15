public class Room {
    private String location;
    private double rent;
    private String roomType;
    private String size;
    private boolean isAvailable;
    private String genderPreference;
    private String leasePeriod;
    private boolean petFriendly;

    public Room(String location, double rent, String roomType, String size, boolean isAvailable,
                String genderPreference, String leasePeriod, boolean petFriendly) {
        this.location = location;
        this.rent = rent;
        this.roomType = roomType;
        this.size = size;
        this.isAvailable = isAvailable;
        this.genderPreference = genderPreference;
        this.leasePeriod = leasePeriod;
        this.petFriendly = petFriendly;
    }

    public String getLocation() { return location; }
    public double getRent() { return rent; }
    public String getRoomType() { return roomType; }
    public String getSize() { return size; }
    public boolean isAvailable() { return isAvailable; }
    public String getGenderPreference() { return genderPreference; }
    public String getLeasePeriod() { return leasePeriod; }
    public boolean isPetFriendly() { return petFriendly; }

    public void printRoomDetails() {
        System.out.println("Location: " + location);
        System.out.println("Rent: " + rent);
        System.out.println("Room Type: " + roomType);
        System.out.println("Size: " + size);
        System.out.println("Available: " + isAvailable);
        System.out.println("Gender Preference: " + genderPreference);
        System.out.println("Lease Period: " + leasePeriod);
        System.out.println("Pet Friendly: " + petFriendly);
    }
}
