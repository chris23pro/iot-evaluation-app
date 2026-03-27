package services;

import java.util.Arrays;
import java.util.List;

public class DatabaseService {
    public List<Double> getLatency(String algorithm) {
        switch (algorithm) {
            case "AES":
                return Arrays.asList(9.1, 8.7, 8.9);
            case "ChaCha20":
                return Arrays.asList(7.8, 8.0, 7.9);
            case "ECC":
                return Arrays.asList(12.3, 11.9, 12.1);
            default:
                return Arrays.asList();
        }
    }
}
