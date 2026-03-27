package org.eclipse.paho.client.mqttv3;

@FunctionalInterface
public interface IMqttMessageListener {
    void messageArrived(String topic, MqttMessage message) throws Exception;
}
