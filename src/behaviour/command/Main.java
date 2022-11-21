package behaviour.command;

//Consumer creates an object that perform actions OR delegates the work to the producer.
//Typically used for delegating the work.
//Resolves implementing same code for consumers.

public class Main {
    public static void main(String[] args) {
        CommandConsumer commandConsumer_0 = new CommandConsumer(new Command_0());
        commandConsumer_0.executeCommand();

        CommandConsumer commandConsumer_1 = new CommandConsumer(new Command_1());
        commandConsumer_1.executeCommand();
    }
}

class CommandConsumer {
    private Command command;

    CommandConsumer(Command command){
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}

interface Command {
    void execute();
}

class Command_0 implements Command{

    @Override
    public void execute() {
        Producer.getInstance().action("Command_0");
    }
}

class Command_1 implements Command{

    @Override
    public void execute() {
        Producer.getInstance().action("Command_1");
    }
}

class Producer {
    private static Producer producer;

    private Producer() {

    }

    public static Producer getInstance() {
        if (producer == null) {
            producer = new Producer();
        }

        return producer;
    }

    public void action(String param) {
        System.out.println("Executing " + param);
    }
}















