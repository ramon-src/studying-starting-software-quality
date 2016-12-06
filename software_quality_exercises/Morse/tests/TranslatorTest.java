
import dictionaries.DefaultDictionary;
import dictionaries.LeetDictionary;
import dictionaries.MorseDictionary;
import exceptions.DictionaryEmptyException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tools.Map;

/**
 * Created by ramon on 11/2/16.
 */
public class TranslatorTest {


    public Translator translator;
    public Map<Integer, String> dictToTest;

    @Before
    public void setUp() {
        translator = new Translator(new DefaultDictionary());
    }

    @Test
    public void translateDefaultToMorse() {
        String translated_phrase = translator.thePhrase("henrique e legal").to(new MorseDictionary()).translate();
        String expected_phrase = ".... . -. .-. .. --.- ..- .   .   .-.. . --. .- .-..";
        Assert.assertEquals(expected_phrase, translated_phrase);
    }
    @Test
    public void translateDefaultToMorseButWithCharThatDoesntExist() {
        String translated_phrase = translator.thePhrase("henr][ique e legal").to(new MorseDictionary()).translate();
        String expected_phrase = ".... . -. .-. ? ? .. --.- ..- .   .   .-.. . --. .- .-..";
        Assert.assertEquals(expected_phrase, translated_phrase);
    }

    @Test
    public void translateMorseToDefault(){
        String phrase = ".... . -. .-. .. --.- ..- .   .   .-.. . --. .- .-..";
        String expected_phrase = "henrique e legal";
        String translated_phrase = translator
                                        .thePhrase(phrase)
                                        .from(new MorseDictionary())
                                        .to(new DefaultDictionary())
                                        .translate();
        Assert.assertEquals(expected_phrase, translated_phrase);
    }

    @Test
    public void translateDefaultToLeet() {
        String translated_phrase = translator.thePhrase("henrique e legal").to(new LeetDictionary()).translate();
        String expected_phrase = "# & /v 12 ! (_,) |_| &    &    1_ & c- @ 1_";
        Assert.assertEquals(expected_phrase, translated_phrase);
    }


    @Test
    public void translateLeetToDefault(){
        String phrase = "# & /v 12 ! (_,) |_| &    &    1_ & c- @ 1_";
        String expected_phrase = "henrique e legal";
        String translated_phrase = translator
                .thePhrase(phrase)
                .from(new LeetDictionary())
                .to(new DefaultDictionary())
                .translate();
        Assert.assertEquals(expected_phrase, translated_phrase);
    }

    @Test
    public void translateLeetToMorse(){
        String phrase = "# & /v 12 ! (_,) |_| &    &    1_ & c- @ 1_";
        String expected_phrase = ".... . -. .-. .. --.- ..- .   .   .-.. . --. .- .-..";
        String translated_phrase = translator
                .thePhrase(phrase)
                .from(new LeetDictionary())
                .to(new MorseDictionary())
                .translate();
        Assert.assertEquals(expected_phrase, translated_phrase);
    }

    @Test
    public void translateMorseToDefaultButWithCharThatDoesntExist(){
        String phrase = ".... . -. .-. kds .. --.- ..- .   .   .-.. . --. .- .-..";
        String expected_phrase = "henr?ique e legal";
        String translated_phrase = translator
                                        .thePhrase(phrase)
                                        .from(new MorseDictionary())
                                        .to(new DefaultDictionary())
                                        .translate();
        Assert.assertEquals(expected_phrase, translated_phrase);
    }


    @Test(expected = DictionaryEmptyException.class)
    public void throwExceptionIfTheDictionaryToTranslteIsNotSet() {
        translator.thePhrase("henrique e legal").translate();
    }

    @Test
    public void whenNoAddDictionaryInFromReturnDefaultDictionary() {
        dictToTest = translator.getOriginDictionary();
        Assert.assertEquals("a", dictToTest.get(0));
    }
}
