package Entites;

public abstract class User {

    private int id;  // id uniquely represents a user
    private String name; private String email; private String number;  // name, email and number of the user

    /**
     *  Constructs a user with the given id, name, email, number
     * @param id int id of the user
     * @param name string name of the user
     * @param email string email of the user
     * @param number string number of the user
     */
    public User(int id, String name, String email, String number) {
        this.id = id; this.name = name; this.email = email; this.number = number;
    }

    // GETTERS AND SETTERS:

    /**
     * Gets the id of the user object
     *
     * @return returns int id of the user
     */

    public int getId() {
        return this.id;
    }

    /**
     * Sets the id of a user object
     *
     * @param id sets the id to given int id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of a user object
     *
     * @return returns string name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of a user object
     *
     * @param name sets the name to the given string id
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the email of a user object
     *
     * @return returns the string email of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of a user object
     *
     * @param email sets the email to the given string email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the phone number of a user object
     *
     * @return returns the string phone number of the user
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets a phone number to a user object
     * 
     * @param number sets the phone number to the given string phone number
     */
    public void setNumber(String number) {
        this.number = number;
    }
}
