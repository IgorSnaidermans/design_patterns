package behaviour.state;

// Adds a State object to the Client class which while executing may change the behaviour.state to others.
// Client class should not have State setter.

public class Main {
    public static void main(String[] args) {
        StateClient stateClient = new StateClient();
        stateClient.setState(new StateImpl_0(stateClient));
        stateClient.printState();
        stateClient.execute();
        stateClient.printState();
        stateClient.execute();
        stateClient.printState();
    }
}

interface State {

    void execute();

    void printState();

}

class StateImpl_0 implements State {

    private final StateClient stateClient;

    public StateImpl_0(StateClient stateClient) {
        this.stateClient = stateClient;
    }

    @Override
    public void execute() {
        System.out.println("executing behaviour.state 0. Switching to behaviour.state 1.");
        stateClient.setState(new StateImpl_1(stateClient));
    }

    @Override
    public void printState() {
        System.out.println("now behaviour.state is set to 0");
    }
}

class StateImpl_1 implements State{

    private final StateClient stateClient;

    public StateImpl_1(StateClient stateClient) {
        this.stateClient = stateClient;
    }

    @Override
    public void execute() {
        System.out.println("executing behaviour.state 1. Switching to behaviour.state 0.");
        stateClient.setState(new StateImpl_0(stateClient));
    }

    @Override
    public void printState() {
        System.out.println("now behaviour.state is set to 1");
    }
}

class StateClient {
    private State state;

    public void execute() {
        state.execute();
    }

    public void printState() {
        state.printState();
    }

    public void setState(State state) {
        this.state = state;
    }
}