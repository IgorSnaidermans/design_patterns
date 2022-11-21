package structure.decorator;

// Extends functionality of a Parent Class without extending it.
// Should be used when extending is not possible for some reason.

public class Main {
    public static void main(String[] args) {
        ParentInterface decorator = new Decorator_1(new Decorator_0(new ParentInterfaceImpl()));
        decorator.execute();
    }
}

interface ParentInterface {
    void execute();
}

class ParentInterfaceImpl implements ParentInterface {

    @Override
    public void execute() {
        System.out.println("executing parent interface implementation");
    }
}

class MainDecorator implements ParentInterface {
    private ParentInterface parentInterface;

    public MainDecorator(ParentInterface parentInterface) {
        this.parentInterface = parentInterface;
    }

    private MainDecorator() {
    }

    @Override
    public void execute() {
        parentInterface.execute();
    }
}

class Decorator_0 extends MainDecorator {

    public Decorator_0(ParentInterface parentInterface) {
        super(parentInterface);
    }

    @Override
    public void execute() {
        super.execute();
        System.out.println("executing Decorator_0");
    }
}

class Decorator_1 extends MainDecorator {

    public Decorator_1(ParentInterface parentInterface) {
        super(parentInterface);
    }

    @Override
    public void execute() {
        super.execute();
        System.out.println("executing Decorator_1");
    }
}