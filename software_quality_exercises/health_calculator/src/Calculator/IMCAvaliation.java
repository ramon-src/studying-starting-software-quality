package Calculator;

import Person.Person;

public class IMCAvaliation {

    private double minTolerable;
    private double maxTolerable;

    public String get(Person person) {
        changeMinMaxBy(person.getGenre());
        double imcResult = new IMC().calculate(person.getWeight(), person.getTall());

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
