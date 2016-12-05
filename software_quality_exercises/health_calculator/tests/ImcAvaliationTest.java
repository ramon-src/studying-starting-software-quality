import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Calculator.IMCAvaliation;
import Person.Person;

public class ImcAvaliationTest {

    IMCAvaliation imcAvaliation;
    String expectAbaixoDoPeso = "Abaixo do peso";
    String expectIdeal = "Ideal";
    String expectObeso = "Obeso";

    @Before
    public void SetUp() {
        imcAvaliation = new IMCAvaliation();
    }

    @Test
    public void getAbaixoDoPesoFromAFemPersonWith40Weight1_65Tall() {
        String result = imcAvaliation.get(new Person("FEM", 1.65, 40));
        Assert.assertEquals(expectAbaixoDoPeso, result);
    }

    @Test
    public void getIdealFromAFemPersonWith56Weight1_65Tall() {
        String result = imcAvaliation.get(new Person("FEM", 1.65, 56));
        Assert.assertEquals(expectIdeal, result);
    }

    @Test
    public void getObesoFromAFemPersonWith75Weight1_65Tall() {
        String result = imcAvaliation.get(new Person("FEM", 1.65, 75));
        Assert.assertEquals(expectObeso, result);
    }

    @Test
    public void getAbaixoDoPesoFromAMascPersonWith56Weight1_65Tall() {
        String result = imcAvaliation.get(new Person("MASC", 1.65, 56));
        Assert.assertEquals(expectAbaixoDoPeso, result);
    }

    @Test
    public void getIdealFromAMascPersonWith58Weight1_65Tall() {
        String result = imcAvaliation.get(new Person("MASC", 1.65, 58));
        Assert.assertEquals(expectIdeal, result);
    }

    @Test
    public void getObesoFromAMascPersonWith75Weight1_65Tall() {
        String result = imcAvaliation.get(new Person("MASC", 1.65, 75));
        Assert.assertEquals(expectObeso, result);
    }
}
