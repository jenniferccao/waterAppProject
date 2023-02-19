public class User {
    private String name;
    private String house;

    // Constructor
    public User(String userName, String userHouse) {
        name = userName;
        house = userHouse;
    }

    public String getName() {
        return name;
    }
    public String getHouse() {
        return house;
    }
}
