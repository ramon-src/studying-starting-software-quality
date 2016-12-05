
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import Calculator.IMC;

public class ImcTest {

    public IMC imc;

    @Before
    public void SetUp() {
        this.imc = new IMC();
    }

    @Test
    public void calcIMC1_8TallAnd70weightResults21_6() {
        double expected = 21.6;
        double result = imc.calculate(70, 1.80);
        Assert.assertEquals(expected, result, 0.1);
    }

}
