package javafx.stage;

import javafx.scene.Scene;

public class Stage {
    private String title;
    private Scene scene;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void show() {
        // no-op stub
    }

    public String getTitle() {
        return title;
    }

    public Scene getScene() {
        return scene;
    }
}
