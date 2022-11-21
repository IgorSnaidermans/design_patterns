package facade;

// Systems with big API may be confusing for the client.
// Client only want one feature.
// Facade is an interface that covers all the details and gives a Client requested API.

public class Main {
    // client needs only call() methods from Services
    // But he doesn't want to know how it should be used, he needs result.
    // instead of
    // service_1.call()
    // service_0.call()
    // service_2.call()

    public static void main(String[] args) {
        ServiceFacade facade = new ServiceFacadeImpl(new Service_0(), new Service_1(), new Service_2());
        facade.execute();
    }
}

class Service_0 {

    public void call() {
        System.out.println("Calling Service_0");
    }

    public void otherExecute() {};
}

class Service_1 {
    public void call() {
        System.out.println("Calling Service_1");
    }

    public void otherExecute() {};
}

class Service_2 {
    public void call() {
        System.out.println("Calling Service_2");
    }

    public void otherExecute() {};
}

interface ServiceFacade {
    void execute();

}

class ServiceFacadeImpl implements ServiceFacade {

    private Service_0 service_0;

    private Service_1 service_1;

    private Service_2 service_2;

    public ServiceFacadeImpl(Service_0 service_0, Service_1 service_1, Service_2 service_2) {
        this.service_0 = service_0;
        this.service_1 = service_1;
        this.service_2 = service_2;
    }

    @Override
    public void execute() {
        service_1.call();
        service_0.call();
        service_2.call();
    }
}