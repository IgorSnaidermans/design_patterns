package prototype;

public class Main {
    public static void main(String[] args) {
        Model model = new Model("John", 25L);
        Model modelClone = model.clone();
        System.out.println("Original model name: " + model.getName() + ". Age: " + model.getAge());
        System.out.println("Cloned model name: " + modelClone.getName() + ". Age: " + modelClone.getAge());
        System.out.println("Is the same object: " + (model == modelClone));
    }
}

class Model implements Cloneable {

    private String name;

    private Long age;

    private Model() {
    }

    public Model(String name, Long age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Long getAge() {
        return age;
    }

    @Override
    public Model clone() {
        Model modelClone = new Model();
        modelClone.age = this.age;
        modelClone.name = this.name;
        return modelClone;
    }
}