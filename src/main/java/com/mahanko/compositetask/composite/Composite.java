package com.mahanko.compositetask.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private final CompositeLevel level;
    private final List<Component> components;

    public Composite(CompositeLevel level) {
        this.level = level;
        components = new ArrayList<>();
    }

    @Override
    public boolean addChild(Component child) {
        return components.add(child);
    }

    @Override
    public boolean removeChild(Component child) {
        return components.remove(child);
    }

    @Override
    public String toString() {
        String result = level.getValue();
        for (Component component : components) {
            result = result.concat(component.toString());
        }

        return result;
    }

}
