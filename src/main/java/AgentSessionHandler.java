public class AgentSessionHandler extends UserSessionHandler {
    private Agent agent;
    BookingSystem bookingSystem;

    public AgentSessionHandler() {
        bookingSystem = new BookingSystem();
    }

    @Override
    public boolean setSessionUserWithId(int id) {
        this.agent = this.bookingSystem.agentsManager.getAgentWithId(id);
        return !this.agent.equals(null);
    }
}
