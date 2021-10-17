import java.util.ArrayList;

public class Agent extends User {

    private ArrayList<User> customers;

    public Agent(int id, String name, String email, String number) {
        super(id, name, email, number);
        this.customers = new ArrayList<>();
    }

    public User getCustomerWithId(int id) {
        int index = -1;

        for (int i = 0; i < this.customers.size(); i++) {
            if (this.customers.get(i).getId() == id) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return null;
        }
        return this.customers.get(index);
    }

    public boolean removeCustomerWithId(int id) {
        int index = -1;

        for (int i = 0; i < this.customers.size(); i++) {
            if (this.customers.get(i).getId() == id) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return false;
        }
        this.customers.remove(index);
        return true;
    }

    public void addCustomer(User u) {
        this.customers.add(u);
    }
}
