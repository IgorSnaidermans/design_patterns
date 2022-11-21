package creation.singleton;

//Creates a single instance of a class and block future instancing.
//May be used for configs.

public class Main {
    public static void main(String[] args) {
        System.out.println(Singleton.getInstance().action());
    }
}

class Singleton {

    private static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }

        return singleton;
    }

    public String action() {
        return "singleton";
    }
}