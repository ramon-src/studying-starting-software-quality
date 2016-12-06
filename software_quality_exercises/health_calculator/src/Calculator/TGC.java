package Calculator;

import Person.Person;

import java.lang.reflect.Array;
import java.util.*;

public class TGC implements Calculator {

    private IMC imc;

    public TGC() {
        this.imc = new IMC();
    }

    public double calculate(Person person) {
        double personIMC = imc.calculate(person);
        return (1.2 * personIMC) - (10.8 * person.getGenreNumber()) + (0.23 * person.getAge()) - 5.4;
    }
}
