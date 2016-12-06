import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Person.Person;
import Calculator.IMC;
public class ImcTest {

    IMC imc;
    String expectAbaixoDoPeso = "Abaixo do peso";
    String expectIdeal = "Ideal";
    String expectObeso = "Obeso";

    @Before
    public void SetUp() {
        imc = new IMC();
    }


    @Test
    public void calcIMC1_8TallAnd70weightResults21_6() {
        double expected = 21.6;
        double result = imc.calculate(new Person("MASC", 1.80, 70));
        Assert.assertEquals(expected, result, 0.1);
    }

    @Test
    public void getAvaliationAbaixoDoPesoFromAFemPersonWith40Weight1_65Tall() {
        String result = imc.getAvaliation(new Person("FEM", 1.65, 40));
        Assert.assertEquals(expectAbaixoDoPeso, result);
    }

    @Test
    public void getAvaliationIdealFromAFemPersonWith56Weight1_65Tall() {
        String result = imc.getAvaliation(new Person("FEM", 1.65, 56));
        Assert.assertEquals(expectIdeal, result);
    }

    @Test
    public void getAvaliationObesoFromAFemPersonWith75Weight1_65Tall() {
        String result = imc.getAvaliation(new Person("FEM", 1.65, 75));
        Assert.assertEquals(expectObeso, result);
    }

    @Test
    public void getAvaliationAbaixoDoPesoFromAMascPersonWith56Weight1_65Tall() {
        String result = imc.getAvaliation(new Person("MASC", 1.65, 56));
        Assert.assertEquals(expectAbaixoDoPeso, result);
    }

    @Test
    public void getAvaliationIdealFromAMascPersonWith58Weight1_65Tall() {
        String result = imc.getAvaliation(new Person("MASC", 1.65, 58));
        Assert.assertEquals(expectIdeal, result);
    }

    @Test
    public void getAvaliationObesoFromAMascPersonWith75Weight1_65Tall() {
        String result = imc.getAvaliation(new Person("MASC", 1.65, 75));
        Assert.assertEquals(expectObeso, result);
    }
}
