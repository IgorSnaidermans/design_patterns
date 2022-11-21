package structure.flyweight;

import java.util.HashMap;

// Creating a factory that stores object with static fields for future use for other objects.
// Static object should have static fields that never changes (internal behaviour.state).
// Dynamic objects have various fields, static (internal behaviour.state) and dynamic (external behaviour.state).

// Resolves the problem where creating a dynamic objects with similar fields results in memory leak.
// As all these similar fields are separate objects.

public class Main {
    public static void main(String[] args) {
        Model tree_5yearsOld = DynamicModelFactory.create(StaticModelType.TREE, 5L);
        Model tree_500yearsOld = DynamicModelFactory.create(StaticModelType.TREE, 500L);

        System.out.println(
                "Object 1 name_staticField: " + tree_5yearsOld.getName_StaticState().name_internalState +
                        ", age: " + tree_5yearsOld.getAge_DynamicState() +
                        "\nObject 2 name_staticField: " + tree_500yearsOld.getName_StaticState().name_internalState +
                        ", age: " + tree_500yearsOld.getAge_DynamicState()
        );
        System.out.println("Object 1 & 2 static field is the same object: "
                + (tree_5yearsOld.getName_StaticState() == tree_500yearsOld.getName_StaticState()));
    }
}

class DynamicModelFactory {

    private static HashMap<StaticModelType, StaticModel> cache = new HashMap<>() {{
        put(StaticModelType.TREE, new StaticModel("tree"));
        put(StaticModelType.ROCK, new StaticModel("rock"));
    }};

    public static Model create(StaticModelType type, long age) {
        Model model = new Model(cache.get(type), age);
        model.setAge_DynamicState(age);
        return model;
    }
}

class StaticModel {
    String name_internalState;

    public StaticModel(String name) {
        this.name_internalState = name;
    }

    public String getName_internalState() {
        return name_internalState;
    }
}

enum StaticModelType {
    TREE,
    ROCK
}

class Model {
    private final StaticModel staticState;

    private long age_DynamicState;

    public Model(StaticModel staticModel, long age) {
        this.staticState = staticModel;
        this.age_DynamicState = age;
    }

    public long getAge_DynamicState() {
        return age_DynamicState;
    }

    public void setAge_DynamicState(long age_DynamicState) {
        this.age_DynamicState = age_DynamicState;
    }

    public StaticModel getName_StaticState() {
        return staticState;
    }
}