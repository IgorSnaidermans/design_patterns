package structure.adapter;

// Client needs Long, Service gives Integer.
// Adapter covers Service, adapts the data and returns it in suitable for Client format.

public class Main {

    public static void main(String[] args) {
        Client client = new Client();
        Adapter adapter = new Adapter(new Service());

        client.execute(adapter.adapt());
    }

}

class Client {
    public void execute(Long data){
        System.out.println("data: " + data + ". Type: " + data.getClass());
    }
}

class Service {
    private final int data = 5;

    public int getData() {
        return data;
    }
}

class Adapter {
    private Service service;

    public Adapter(Service service) {
        this.service = service;
    }

    public long adapt() {
        return service.getData();
    }
}
