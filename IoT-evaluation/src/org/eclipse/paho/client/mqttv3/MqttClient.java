package org.eclipse.paho.client.mqttv3;

import java.util.HashMap;
import java.util.Map;

public class MqttClient {
    private final String brokerUrl;
    private final String clientId;
    private final Map<String, IMqttMessageListener> listeners = new HashMap<>();

    public MqttClient(String brokerUrl, String clientId) {
        this.brokerUrl = brokerUrl;
        this.clientId = clientId;
    }

    public void connect() {
        // no-op stub
    }

    public void subscribe(String topic, IMqttMessageListener listener) {
        listeners.put(topic, listener);
    }

    public String getBrokerUrl() {
        return brokerUrl;
    }

    public String getClientId() {
        return clientId;
    }
}
