package javafx.scene.chart;

import java.util.ArrayList;
import java.util.List;

public class XYChart<X, Y> {
    public static class Data<X, Y> {
        private final X xValue;
        private final Y yValue;

        public Data(X xValue, Y yValue) {
            this.xValue = xValue;
            this.yValue = yValue;
        }

        public X getXValue() {
            return xValue;
        }

        public Y getYValue() {
            return yValue;
        }
    }

    public static class Series<X, Y> {
        private String name;
        private final List<Data<X, Y>> data = new ArrayList<>();

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public List<Data<X, Y>> getData() {
            return data;
        }
    }
}
