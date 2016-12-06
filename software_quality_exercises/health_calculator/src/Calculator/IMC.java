package Calculator;

import Person.Person;

public class IMC implements Calculator {

    private double minTolerable;
    private double maxTolerable;

    public double calculate(Person person) {
        return person.getWeight() / Math.pow(person.getTall(), 2);
    }

    public String getAvaliation(Person person) {
        changeMinMaxBy(person.getGenre());
        double imcResult = calculate(person);

        if (imcResult < minTolerable) {
            return "Abaixo do peso";
        } else if (imcResult > maxTolerable) {
            return "Obeso";
        } else {
            return "Ideal";
        }
    }

    private void changeMinMaxBy(String genre) {
        if (genre.equals("FEM")) {
            minTolerable = 19.1;
            maxTolerable = 25.8;
        } else {
            minTolerable = 20.7;
            maxTolerable = 26.4;
        }
    }

}
