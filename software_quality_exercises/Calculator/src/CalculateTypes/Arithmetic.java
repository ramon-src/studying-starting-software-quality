package CalculateTypes;

import java.util.Map;

public class Arithmetic implements Calculation {

    public Double calculate(Map<Integer, Map<Double, Double>> values) {
        Double sum = 0.0;
        for (Map.Entry<Integer, Map<Double, Double>> value : values.entrySet()) {
            for (Map.Entry<Double, Double> set : values.get(value.getKey()).entrySet()) {
                sum += set.getKey();
            }
        }
        return sum / values.size();
    }
}
