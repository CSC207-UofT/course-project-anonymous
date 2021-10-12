public abstract class User {
    private int id;  // id uniquely represents a user
    private String name; private String email; private int number;  // name, email and number of the user

    public User(int id, String name, String email, int number) {
        this.id = id; this.name = name; this.email = email; this.number = number;
    }

    // GETTERS AND SETTERS:

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
