public class User {
    private String name;
    private int age;
    private double budget;
    private String gender;
    private String preferredRoomType;
    private String preferredLocation;
    private String leasePeriod;
    private boolean petFriendly;

    public User(String name, int age, double budget, String gender, String preferredRoomType,
                String preferredLocation, String leasePeriod, boolean petFriendly) {
        this.name = name;
        this.age = age;
        this.budget = budget;
        this.gender = gender;
        this.preferredRoomType = preferredRoomType;
        this.preferredLocation = preferredLocation;
        this.leasePeriod = leasePeriod;
        this.petFriendly = petFriendly;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getBudget() { return budget; }
    public String getGender() { return gender; }
    public String getPreferredRoomType() { return preferredRoomType; }
    public String getPreferredLocation() { return preferredLocation; }
    public String getLeasePeriod() { return leasePeriod; }
    public boolean isPetFriendly() { return petFriendly; }
}
