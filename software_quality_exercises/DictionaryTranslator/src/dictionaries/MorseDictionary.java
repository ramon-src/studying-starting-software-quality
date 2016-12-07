package dictionaries;

import tools.Map;

public class MorseDictionary extends DictionaryAbstract {

    private Map<Integer, String> dictionary;

    public MorseDictionary() {
        String[] alphabet = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-.."
                , "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
                "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----"
        };
        dictionary = createDictionary(alphabet);
        SEPARATE_WORD = "   ";
        SEPARATE_LETTER = " ";
    }

    @Override
    public Map<Integer, String> getDictionary() {
        return dictionary;
    }

    public String getWordSeparator() {
        return SEPARATE_WORD;
    }

    public String getLetterSeparator() {
        return SEPARATE_LETTER;
    }
}
