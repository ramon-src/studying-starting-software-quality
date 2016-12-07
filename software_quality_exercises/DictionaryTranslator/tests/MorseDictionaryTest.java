import dictionaries.MorseDictionary;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MorseDictionaryTest {

    public MorseDictionary dict;

    @Before
    public void setUp() {
        dict = new MorseDictionary();
    }

    @Test
    public void getDictionaryKey0EqualsAInMorse(){
        Assert.assertEquals(".-", dict.getDictionary().get(0));
    }
}
