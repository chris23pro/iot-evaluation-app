package javafx.application;

public final class Platform {
    private Platform() {}

    public static void runLater(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }
}
