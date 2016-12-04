package CalculateTypes;

import java.util.Map;

public class Weighted implements Calculation {

    public Double calculate(Map<Integer, Map<Double, Double>> values) {
        Double sumToDivide = 0.0;
        Double sumWithWeight = 0.0;
        for (Map.Entry<Integer, Map<Double, Double>> value : values.entrySet()) {
            for (Map.Entry<Double, Double> set : values.get(value.getKey()).entrySet()) {
                sumToDivide += set.getKey();
                sumWithWeight += (set.getKey() * set.getValue());
            }
        }
        return sumWithWeight / sumToDivide;
    }
}
