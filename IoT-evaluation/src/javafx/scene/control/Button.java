package javafx.scene.control;

import java.util.function.Consumer;

public class Button {
    private final String text;
    private Consumer<Object> onAction;

    public Button(String text) {
        this.text = text;
    }

    public void setOnAction(Consumer<Object> onAction) {
        this.onAction = onAction;
    }

    public void fire() {
        if (onAction != null) {
            onAction.accept(null);
        }
    }

    public String getText() {
        return text;
    }
}
