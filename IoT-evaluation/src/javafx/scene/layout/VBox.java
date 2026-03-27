package javafx.scene.layout;

import java.util.ArrayList;
import java.util.Collection;

public class VBox {
    private final double spacing;
    private final ChildrenList children = new ChildrenList();

    public VBox(double spacing) {
        this.spacing = spacing;
    }

    public double getSpacing() {
        return spacing;
    }

    public ChildrenList getChildren() {
        return children;
    }

    public static class ChildrenList extends ArrayList<Object> {
        public boolean addAll(Object... nodes) {
            boolean changed = false;
            for (Object node : nodes) {
                changed |= super.add(node);
            }
            return changed;
        }

        @Override
        public boolean addAll(Collection<?> c) {
            return super.addAll(c);
        }
    }
}
