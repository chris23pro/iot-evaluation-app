package views;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.HashMap;

public class GraphView extends LineChart<Number, Number> {

    private HashMap<String, XYChart.Series<Number, Number>> seriesMap = new HashMap<>();
    private int xCounter = 0;

    public GraphView() {
        super(new NumberAxis(), new NumberAxis());
        this.setTitle("IoT Real-time Data");
    }

    public void addSeries(String name) {
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName(name);
        this.getData().add(series);
        seriesMap.put(name, series);
    }

    public void updateData(String seriesName, double newValue) {
        XYChart.Series<Number, Number> series = seriesMap.get(seriesName);
        if (series == null) {
            addSeries(seriesName);
            series = seriesMap.get(seriesName);
        }
        series.getData().add(new XYChart.Data<>(xCounter++, newValue));
        if (series.getData().size() > 50) { // keep last 50 points
            series.getData().remove(0);
        }
    }
}
