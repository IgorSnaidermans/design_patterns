package behaviour.strategy;

// Adds a Strategy object for other logic.
// Strategy should be set with setter in StrategyClient.

public class Main {
    public static void main(String[] args) {
        StrategyClient strategyClient = new StrategyClient();
        strategyClient.setStrategy(new StrategyImpl_0());
        strategyClient.executeStrategy();
        strategyClient.setStrategy(new StrategyImpl_1());
        strategyClient.executeStrategy();
    }
}

interface Strategy {
    void execute();
}

class StrategyImpl_0 implements Strategy{

    @Override
    public void execute() {
        System.out.println("executing behaviour.strategy 0");
    }
}

class StrategyImpl_1 implements Strategy{

    @Override
    public void execute() {
        System.out.println("executing behaviour.strategy 1");
    }
}

class StrategyClient {

    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy() {
        strategy.execute();
    }
}