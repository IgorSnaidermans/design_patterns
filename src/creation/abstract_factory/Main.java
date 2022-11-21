package creation.abstract_factory;

// Factory creates objects.

public class Main {

    public static void main(String[] args) {
        ObjectFactory objectFactory_0 = new ObjectFactory_0();
        MainObject mainObject_0 = objectFactory_0.createObject();
        ObjectFactory objectFactory_1 = new ObjectFactory_1();
        MainObject mainObject_1 = objectFactory_1.createObject();
    }
}

interface MainObject {
}

class Object_0 implements MainObject {
}

class Object_1 implements MainObject {
}

interface ObjectFactory {
    MainObject createObject();
}

class ObjectFactory_0 implements ObjectFactory {

    @Override
    public MainObject createObject() {
        System.out.println("ObjectFactory_0 creates Object_0");
        return new Object_0();
    }
}

class ObjectFactory_1 implements ObjectFactory {

    @Override
    public MainObject createObject() {
        System.out.println("ObjectFactory_1 creates Object_1");
        return new Object_1();
    }
}