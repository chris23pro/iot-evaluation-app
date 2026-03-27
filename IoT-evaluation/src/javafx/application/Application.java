package javafx.application;

import javafx.stage.Stage;

public abstract class Application {
    public abstract void start(Stage stage);

    public static void launch() {
        // no-op stub for non-JavaFX environments
    }
}
