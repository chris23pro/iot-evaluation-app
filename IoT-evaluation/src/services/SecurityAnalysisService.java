package services;

import java.util.HashMap;
import java.util.Map;

public class SecurityAnalysisService {
    public HashMap<String, String> evaluate(Map<String, Double> latency, Map<String, Double> energy) {
        HashMap<String, String> decisions = new HashMap<>();

        for (String algorithm : latency.keySet()) {
            double score = latency.getOrDefault(algorithm, 0.0) + energy.getOrDefault(algorithm, 0.0);
            decisions.put(algorithm, score <= 18.0 ? "Recommended" : "Review");
        }

        return decisions;
    }
}
