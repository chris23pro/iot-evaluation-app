package javafx.scene.chart;

import java.util.ArrayList;
import java.util.List;

public class LineChart<X, Y> {
    private final NumberAxis xAxis;
    private final NumberAxis yAxis;
    private String title;
    private final List<XYChart.Series<X, Y>> data = new ArrayList<>();

    public LineChart(NumberAxis xAxis, NumberAxis yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public List<XYChart.Series<X, Y>> getData() {
        return data;
    }

    public NumberAxis getXAxis() {
        return xAxis;
    }

    public NumberAxis getYAxis() {
        return yAxis;
    }
}
