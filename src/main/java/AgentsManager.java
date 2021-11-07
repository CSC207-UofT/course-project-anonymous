import java.util.ArrayList;

public class AgentsManager {
    private int currentIdCount = 0;
    ArrayList<Agent> agents;

    public AgentsManager() {
        this.agents = new ArrayList<>();
    }

    public void addPassenger(String name, String email, String number) {
        this.agents.add(new Agent(this.currentIdCount, name, email, number));
        this.currentIdCount++;
    }

    public Agent getAgentWithId(int id) {
        int index = -1;

        for (int i = 0; i < this.agents.size(); i++) {
            if (this.agents.get(i).getId() == id) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return null;
        }
        return this.agents.get(index);
    }

    public boolean removeAgentWithId(int id) {
        int index = -1;

        for (int i = 0; i < this.agents.size(); i++) {
            if (this.agents.get(i).getId() == id) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return false;
        }
        this.agents.remove(index);
        return true;
    }
}
