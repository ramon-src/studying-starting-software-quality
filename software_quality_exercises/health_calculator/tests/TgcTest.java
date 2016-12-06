
import Person.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Calculator.TGC;

public class TgcTest {

    TGC tgc;
    Person man;
    Person woman;

    @Before
    public void SetUp() {
        tgc = new TGC();

        man = new Person("MASC", 30, 1.80, 70);
        woman = new Person("FEM", 1.65, 40);
    }

    @Test
    public void calculateTGC16_62ToAMan() {
        double expected = 16.62;
        double result = tgc.calculate(man);
        Assert.assertEquals(expected, result, 0.1);
    }
}
