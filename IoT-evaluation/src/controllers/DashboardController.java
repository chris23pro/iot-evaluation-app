package controllers;

import javafx.application.Platform;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import services.MQTTService;
import services.DatabaseService;
import services.SecurityAnalysisService;
import views.GraphView;

import java.util.HashMap;
import java.util.Arrays;

public class DashboardController {

    private MQTTService mqttService;
    private SecurityAnalysisService securityAnalysis;
    private DatabaseService databaseService;
    private GraphView graphView;

    public DashboardController(GraphView graphView) {
        this.graphView = graphView;
        mqttService = new MQTTService();
        securityAnalysis = new SecurityAnalysisService();
        databaseService = new DatabaseService();
    }

    public void initDashboard(VBox root, Label dataLabel) {
        // Load latency from DB
        double[] aes = databaseService.getLatency("AES").stream().mapToDouble(Double::doubleValue).toArray();
        double[] chacha = databaseService.getLatency("ChaCha20").stream().mapToDouble(Double::doubleValue).toArray();
        double[] ecc = databaseService.getLatency("ECC").stream().mapToDouble(Double::doubleValue).toArray();

        HashMap<String, Double> latency = new HashMap<>();
        latency.put("AES", Arrays.stream(aes).average().orElse(0));
        latency.put("ChaCha20", Arrays.stream(chacha).average().orElse(0));
        latency.put("ECC", Arrays.stream(ecc).average().orElse(0));

        HashMap<String, Double> energy = new HashMap<>();
        energy.put("AES", 8.5);
        energy.put("ChaCha20", 9.0);
        energy.put("ECC", 7.8);

        HashMap<String, String> result = securityAnalysis.evaluate(latency, energy);

        // Display result on VBox
        result.forEach((alg, res) -> {
            Label label = new Label(alg + " Deployment: " + res);
            root.getChildren().add(label);
        });

        // Connect MQTT and update graph live
        mqttService.connect(dataLabel);

        mqttService.subscribe("iot/sensors/temperature", (topic, message) -> {
            double value = Double.parseDouble(new String(message.getPayload()));
            Platform.runLater(() -> graphView.updateData("Temperature", value));
        });

        mqttService.subscribe("iot/energy/power", (topic, message) -> {
            double value = Double.parseDouble(new String(message.getPayload()));
            Platform.runLater(() -> graphView.updateData("Power", value));
        });
    }
}