package javafx.scene;

public class Scene {
    private final Object root;
    private final double width;
    private final double height;

    public Scene(Object root, double width, double height) {
        this.root = root;
        this.width = width;
        this.height = height;
    }

    public Object getRoot() {
        return root;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
