package org.eclipse.paho.client.mqttv3;

public class MqttMessage {
    private final byte[] payload;

    public MqttMessage(byte[] payload) {
        this.payload = payload;
    }

    public byte[] getPayload() {
        return payload;
    }
}
