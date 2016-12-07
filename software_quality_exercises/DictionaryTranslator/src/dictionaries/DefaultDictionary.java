package dictionaries;

import tools.Map;

public class DefaultDictionary extends DictionaryAbstract {

    private Map<Integer, String> dictionary;

    public DefaultDictionary() {
        String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        dictionary = createDictionary(alphabet);

        SEPARATE_WORD = " ";
        SEPARATE_LETTER = "";
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
