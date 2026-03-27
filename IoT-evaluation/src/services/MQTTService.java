package services;

import javafx.application.Platform;
import javafx.scene.control.Label;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttClient;

public class MQTTService {

    private MqttClient client;

    public void connect(Label dataLabel) {

        try {
            if (client == null) {
                client = new MqttClient("tcp://192.168.1.X:1883", "JavaClient");
                client.connect();
                System.out.println("Connected to MQTT");
            }

            client.subscribe("iot/#", (topic, message) -> {

                String msg = new String(message.getPayload());

                System.out.println("Received: " + msg);

                Platform.runLater(() -> dataLabel.setText(msg));
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void subscribe(String topic, IMqttMessageListener listener) {
        try {
            if (client != null) {
                client.subscribe(topic, listener);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
