package Calculator;

public class IMC implements Calculator {

    public double calculate(double weight, double tall) {
        return weight / Math.pow(tall, 2);
    }

}
